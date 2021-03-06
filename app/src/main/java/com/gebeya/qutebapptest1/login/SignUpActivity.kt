package com.gebeya.qutebapptest1.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.gebeya.qutebapptest1.R
import com.gebeya.qutebapptest1.authentication.ApiClient
import com.gebeya.qutebapptest1.authentication.SessionManager
import com.gebeya.qutebapptest1.board.NoticeBoardActivity
import com.gebeya.qutebapptest1.login.LoginActivity.Companion.sessionManager
import com.gebeya.qutebapptest1.model.LoginRequest
import com.gebeya.qutebapptest1.model.LoginResponse
import com.gebeya.qutebapptest1.model.SignupRequest
import com.gebeya.qutebapptest1.model.SignupResponse
import kotlinx.android.synthetic.main.activity_sign_up.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SignUpActivity : AppCompatActivity() {

    //region DEFINITIONS
    var fullName = ""
    var email = "something@gmail.com"
    var password = ""
    var confirmPassword = ""
    //endregion

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        //we don't want the action bar
        supportActionBar?.hide()

        //user has to click 'I agree' before the app can continue.
        btn_signup_signup.isClickable = false
        btn_signup_signup.isEnabled = false

        cb_signup_i_agree_to_terms.setOnCheckedChangeListener { compoundButton, b ->
            btn_signup_signup.isEnabled = true
            btn_signup_signup.isClickable = compoundButton.isChecked
        }

        btn_signup_signup.setOnClickListener {
            if (cb_signup_i_agree_to_terms.isChecked) {
                //enteredDataCheck()
                startActivity(Intent(this@SignUpActivity, NoticeBoardActivity::class.java))
                finish()
            }
        }

    }


    private fun enteredDataCheck() {

        //region This probably only works below API level 30
//        if(!Patterns.EMAIL_ADDRESS.matcher(et_signup_phone_email.text.toString()).matches()){
//            et_signup_phone_email.error = "Please enter valid email"
//            et_signup_phone_email.requestFocus()
//            return
//        }
        //endregion

        fullName = et_signup_your_first_name.text.toString()
        email = et_signup_phone_email.text.toString()
        password = et_signup_password.text.toString()
        confirmPassword = et_signup_confirm_password.text.toString()

        if (!LoginActivity.emailRegex.matcher(email).matches()) {
            et_signup_phone_email.error = "Please enter valid email."
            et_signup_phone_email.requestFocus()
            return
        }


        if (et_signup_phone_email.text.toString().isEmpty()) {
            et_signup_phone_email.error = "Please enter email"
            et_signup_phone_email.requestFocus()
            return
        }

        if (et_signup_password.text.toString().isEmpty()) {
            et_signup_password.error = "Please enter password"
            et_signup_password.requestFocus()
            return
        }

        if (et_signup_confirm_password.text.toString().isEmpty()) {
            et_signup_password.error = "Please re-enter password"
            et_signup_confirm_password.requestFocus()
            return
        }

        if (et_signup_password.text.toString() != et_signup_confirm_password.text.toString()) {
            Toast.makeText(this, "Passwords don't match", Toast.LENGTH_LONG).show()
            return
        }

        email = et_signup_phone_email.text.toString()
        password = et_signup_password.text.toString()

        signInUser(fullName, email, password)

    }

    private fun signInUser(fullName: String, email: String, password: String) {
        LoginActivity.apiClient = ApiClient()
        sessionManager = SessionManager(this)

        LoginActivity.apiClient.getApiService(this).signup(SignupRequest(fullName, email, password))
            .enqueue(object : Callback<SignupResponse> {
                override fun onFailure(call: Call<SignupResponse>, t: Throwable) {
                    Toast.makeText(applicationContext, "OnFailure Called!", Toast.LENGTH_LONG)
                        .show()
                }

                override fun onResponse(
                    call: Call<SignupResponse>,
                    response: Response<SignupResponse>
                ) {
                    val SignupResponse = response.body()

                    when (response.code()) {

                        200 -> {
                            Toast.makeText(
                                applicationContext,
                                "Success!",
                                Toast.LENGTH_LONG
                            ).show()

                            sessionManager.saveAuthToken(SignupResponse!!.token)
                            //Move to the next activity
                            startActivity(Intent(this@SignUpActivity, NoticeBoardActivity::class.java))
                            finish()
                        }

                        in 400..499 -> {
                            Toast.makeText(
                                applicationContext,
                                "Client error - Invalid data from client",
                                Toast.LENGTH_LONG
                            ).show()
                        }

                        in 500..599 -> {
                            Toast.makeText(
                                applicationContext,
                                "Server error",
                                Toast.LENGTH_LONG
                            )
                                .show()
                        }

                        else -> {
                            Log.d(this.javaClass.simpleName, "OnResponse unhandled status code")
                        }
                    }
                }

            })
    }
}