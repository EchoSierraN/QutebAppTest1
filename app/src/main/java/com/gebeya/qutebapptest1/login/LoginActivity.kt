package com.gebeya.qutebapptest1.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import android.widget.Toast
import com.gebeya.qutebapptest1.R
import com.gebeya.qutebapptest1.authentication.ApiClient
import com.gebeya.qutebapptest1.authentication.SessionManager
import com.gebeya.qutebapptest1.board.BottomNavBoard
import com.gebeya.qutebapptest1.board.NoticeBoardActivity
import com.gebeya.qutebapptest1.model.LoginRequest
import com.gebeya.qutebapptest1.model.LoginResponse
import com.gebeya.qutebapptest1.model.User
import com.gebeya.qutebapptest1.welcome.ForgotPasswordActivity
import kotlinx.android.synthetic.main.activity_login.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.regex.Pattern

class LoginActivity : AppCompatActivity() {

    //region DEFINITIONS
    companion object {
        const val tag = "MainActivity"
        var currentToken: String = ""
        val emailRegex = Pattern.compile(
            "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" +
                    "\\@" +
                    "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +
                    "(" +
                    "\\." +
                    "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" +
                    ")+"
        )

        var currentUser: User = User()

        /*Maybe put these definitions somewhere else? Somewhere more common
        * to all activities?*/
        lateinit var sessionManager: SessionManager
        lateinit var apiClient: ApiClient
    }

    private lateinit var email: String
    private lateinit var password: String
    //endregion

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        //we don't want the action bar
        supportActionBar?.hide()

        apiClient = ApiClient()
        sessionManager = SessionManager(this)

//        if (sessionManager.hasRememberedUser()) {
//            val intentDashboard = Intent(this, DashboardActivity::class.java)
//            startActivity(intentDashboard)
//            finish()
//        }

        tv_login_sign_up.setOnClickListener {
            startActivity(Intent(this, SignUpActivity::class.java))
        }

        tv_login_forgot_password.setOnClickListener {
            startActivity(Intent(this, ForgotPasswordActivity::class.java))
        }

        btn_login_sign_in.setOnClickListener {
            enteredDataCheck(et_login_email, et_login_password)
            //save whether the user will have to login again on restart
            //rememberUser()
        }

    }

    private fun enteredDataCheck(etEmail: EditText?, etPassword: EditText?) {

        //region This probably only works below API level 30
//        if(!Patterns.EMAIL_ADDRESS.matcher(et_login_email.text.toString()).matches()){
//            et_login_email.error = "Please enter valid email"
//            et_login_email.requestFocus()
//            return
//        }
        //endregion

        if (et_login_email.text.toString().isEmpty()) {
            et_login_email.error = "Please enter email"
            et_login_email.requestFocus()
            return
        }

        if (!emailRegex.matcher(et_login_email.text).matches()) {
            et_login_email.error = "Please enter valid email."
            et_login_email.requestFocus()
            return
        }

        if (et_login_password.text.toString().isEmpty()) {
            et_login_password.error = "Please enter password"
            return
        }

        email = etEmail!!.text.toString()
        password = etPassword!!.text.toString()

        checkLoginDetails(currentToken)
    }

    private fun checkLoginDetails(authToken: String) {

        apiClient= ApiClient()
        sessionManager= SessionManager(this)

//        apiClient.getApiService(this).test().enqueue(object: Callback<Any>{
//            /**
//             * Invoked when a network exception occurred talking to the server or when an unexpected
//             * exception occurred creating the request or processing the response.
//             */
//            override fun onFailure(call: Call<Any>, t: Throwable) {
//                Toast.makeText(applicationContext, "OnFailure called", Toast.LENGTH_SHORT).show()
//            }
//
//            /**
//             * Invoked for a received HTTP response.
//             *
//             *
//             * Note: An HTTP response may still indicate an application-level failure such as a 404 or 500.
//             * Call [Response.isSuccessful] to determine if the response indicates success.
//             */
//            override fun onResponse(call: Call<Any>, response: Response<Any>) {
//                Toast.makeText(applicationContext, "SUCCESS called", Toast.LENGTH_SHORT).show()
//            }
//
//
//        })

        apiClient.getApiService(this).login(LoginRequest(email, password))
            .enqueue(object : Callback<LoginResponse> {
                override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                    Toast.makeText(applicationContext, "OnFailure Called!", Toast.LENGTH_LONG)
                        .show()
                    Log.d("AuthError", t.message.toString())
                }

                override fun onResponse(
                    call: Call<LoginResponse>,
                    response: Response<LoginResponse>
                ) {
                    val loginResponse = response.body()

                    when (response.code()) {

                        200 -> {
                            Toast.makeText(
                                applicationContext,
                                "Success!",
                                Toast.LENGTH_LONG
                            ).show()

                            sessionManager.saveAuthToken(loginResponse!!.token)
                            //Move to the next activity
                            startActivity(Intent(this@LoginActivity, BottomNavBoard::class.java))
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