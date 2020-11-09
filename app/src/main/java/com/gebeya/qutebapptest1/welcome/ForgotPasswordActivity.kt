package com.gebeya.qutebapptest1.welcome

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.gebeya.qutebapptest1.R
import com.gebeya.qutebapptest1.authentication.ApiClient
import com.gebeya.qutebapptest1.authentication.ApiService
import com.gebeya.qutebapptest1.login.LoginActivity
import com.gebeya.qutebapptest1.model.PasswordResetCodeRequest
import com.gebeya.qutebapptest1.model.PasswordResetCodeResponse
import kotlinx.android.synthetic.main.activity_forgot_password.*
import kotlinx.android.synthetic.main.activity_login.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

const val PASSWORD_RESET_EMAIL= "passwordResetEmail"

class ForgotPasswordActivity : AppCompatActivity() {

    lateinit var apiClient: ApiClient
    var email: String= ""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot_password)

        apiClient = ApiClient()

        btn_forgot_password_send_link.setOnClickListener {
            //check entered data and send
            enteredDataCheck()
            //move to the verification activity
            //startActivity(Intent(this, EnterVerification::class.java))
        }
    }

    private fun enteredDataCheck() {
        //
        if (et_forgot_password_email.text.toString().isEmpty()) {
            et_forgot_password_email.error = "Please enter email"
            et_forgot_password_email.requestFocus()
            return
        }

        if (!LoginActivity.emailRegex.matcher(et_forgot_password_email.text.toString()).matches()) {
            et_forgot_password_email.error = "Please enter valid email."
            et_forgot_password_email.requestFocus()
            return
        }

        apiClient.getApiService(this)
            .passwordResetCodeRequest(PasswordResetCodeRequest(et_forgot_password_email.text.toString()))
            .enqueue(object : Callback<PasswordResetCodeResponse>{
                /**
                 * Invoked when a network exception occurred talking to the server or when an unexpected
                 * exception occurred creating the request or processing the response.
                 */
                override fun onFailure(call: Call<PasswordResetCodeResponse>, t: Throwable) {
                    Log.d(this::class.java.simpleName, t.message.toString())
                    Toast.makeText(applicationContext, "OnFailure Called!", Toast.LENGTH_LONG)
                        .show()
                }

                /**
                 * Invoked for a received HTTP response.
                 *
                 *
                 * Note: An HTTP response may still indicate an application-level failure such as a 404 or 500.
                 * Call [Response.isSuccessful] to determine if the response indicates success.
                 */
                override fun onResponse(
                    call: Call<PasswordResetCodeResponse>,
                    response: Response<PasswordResetCodeResponse>
                ) {
                    email= et_forgot_password_email.text.toString()

                    if(response.isSuccessful){
                        //display a toast saying an email has been sent
                        val message= response.body()?.message
                        Toast.makeText(applicationContext, "$message", Toast.LENGTH_LONG)
                            .show()

                        //move to the Enter Verification Activity
                        val intentEnterVerification= Intent(this@ForgotPasswordActivity, EnterVerification::class.java)
                        //send the email to the next activity. You'll need it there.
                        intentEnterVerification.putExtra(PASSWORD_RESET_EMAIL, email)
                        //start the next activity
                        startActivity(intentEnterVerification)
                    }
                }

            })

    }


}