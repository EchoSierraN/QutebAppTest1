package com.gebeya.qutebapptest1.login

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.gebeya.qutebapptest1.R
import com.gebeya.qutebapptest1.authentication.ApiClient
import com.gebeya.qutebapptest1.authentication.SessionManager
import com.gebeya.qutebapptest1.board.NoticeBoardActivity
import com.gebeya.qutebapptest1.board.fragments.DashboardIncomeFragment
import com.gebeya.qutebapptest1.board.fragments.DashboardSpendingFragment
import com.gebeya.qutebapptest1.model.SignupRequest
import com.gebeya.qutebapptest1.model.SignupResponse
import kotlinx.android.synthetic.main.activity_sign_up.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

const val DASHBOARD_NAME= "intentNoticeBoardActivity"

class SignUpActivity : AppCompatActivity() {

    lateinit var apiClient: ApiClient
    lateinit var sessionManager: SessionManager

    //region DEFINITIONS
    var fullName = ""
    var email = "something@gmail.com"
    var password = ""
    var confirmPassword = ""
    //endregion

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        apiClient = ApiClient()
        sessionManager = SessionManager(this)

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
                enteredDataCheck()
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

        //region MINIMUM LENGTH
        val minFullNameLength= 5
        val minPasswordLength= 5

        if(et_signup_your_first_name.text.toString().length< 5){
            et_signup_your_first_name.error= "Minimum character length is 5"
            return
        }

        if(et_signup_password.text.toString().length< 6){
            et_signup_password.error= "Minimum password length is 6"
            return
        }
        //endregion

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
            et_signup_password.error= "Passwords don't match"
            et_signup_password.requestFocus()
            return
        }

        email = et_signup_phone_email.text.toString()
        password = et_signup_password.text.toString()

        signUpUser(fullName, email, password)

    }

    private fun signUpUser(fullName: String, email: String, password: String) {
        apiClient.getApiService(this).signup(SignupRequest(fullName, email, password))
            .enqueue(object : Callback<SignupResponse> {
                override fun onFailure(call: Call<SignupResponse>, t: Throwable) {
                    Toast.makeText(applicationContext, "OnFailure Called! ", Toast.LENGTH_LONG)
                        .show()

                    Log.d("AuthError", t.message.toString())
                }

                override fun onResponse(
                    call: Call<SignupResponse>,
                    response: Response<SignupResponse>
                ) {
                    val signupResponse = response.body()

                    when (response.code()) {

                        200 -> {
                            Toast.makeText(
                                applicationContext,
                                "Success!",
                                Toast.LENGTH_LONG
                            ).show()

                            //get all data from response, save it in sessionmanager
                            sessionManager.saveAuthToken(signupResponse!!.token)
                            sessionManager.saveCurrentUserData(
                                signupResponse.fullName,
                                signupResponse.id,
                                signupResponse.email,
                                signupResponse.expiration,
                                signupResponse.token
                            )

                            //send the data you need to the next activity
                            val bundle= Bundle()
                            bundle.putString(DASHBOARD_NAME, fullName)
                            val fragSpending = DashboardSpendingFragment()
                            val fragIncome= DashboardIncomeFragment()
                            fragSpending.arguments= bundle
                            fragIncome.arguments= bundle

                            //Move to the next activity
                            var intentNoticeBoardActivity= Intent(this@SignUpActivity, NoticeBoardActivity::class.java)
                            startActivity(intentNoticeBoardActivity)
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