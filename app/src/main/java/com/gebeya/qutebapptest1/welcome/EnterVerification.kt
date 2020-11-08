package com.gebeya.qutebapptest1.welcome

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.gebeya.qutebapptest1.R
import com.gebeya.qutebapptest1.authentication.ApiClient
import com.gebeya.qutebapptest1.login.LoginActivity
import com.gebeya.qutebapptest1.model.ResetPasswordRequest
import com.gebeya.qutebapptest1.model.ResetPasswordResponse
import kotlinx.android.synthetic.main.activity_enter_verification.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class EnterVerification : AppCompatActivity() {

    var email: String = ""
    lateinit var apiClient: ApiClient

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_enter_verification)

        apiClient = ApiClient()

        //receive the email from the FORGOT PASSWORD page.
        email = intent.getStringExtra(PASSWORD_RESET_EMAIL)!!

        btn_enter_verification_reset_password.setOnClickListener {
            //do an enteredDataCheck
            enteredDataCheck()
            //reset password
            //move to the next activity
            startActivity(Intent(this, LoginActivity::class.java))
            finish()

        }
    }

    private fun enteredDataCheck() {
        //check if verification is null
        if (et_enter_verification_verification.text.toString().isEmpty()) {
            et_enter_verification_verification.error = "Please enter verification code"
            et_enter_verification_verification.requestFocus()
            return
        }
        //check if new password is null
        if (et_enter_verification_new_password.text.toString().isEmpty()) {
            et_enter_verification_new_password.error = "Please enter password code"
            et_enter_verification_new_password.requestFocus()
            return
        }
        //check if it's 6 digit.
        if (et_enter_verification_verification.text.toString().count() != 6) {
            et_enter_verification_verification.error = "Verification code must be of 6 characters."
            et_enter_verification_verification.requestFocus()
            return
        }
        //check if password's a min of 6 digits
        if (et_enter_verification_new_password.text.toString().count() < 6) {
            et_enter_verification_new_password.error = "Verification code must be of 6 characters."
            et_enter_verification_new_password.requestFocus()
            return
        }

        apiClient.getApiService(this)
            .resetPasswordRequest(
                ResetPasswordRequest(
                    email,
                    et_enter_verification_verification.text.toString(),
                    et_enter_verification_new_password.text.toString()
                )
            ).enqueue(object: Callback<ResetPasswordResponse>{
                /**
                 * Invoked when a network exception occurred talking to the server or when an unexpected
                 * exception occurred creating the request or processing the response.
                 */
                override fun onFailure(call: Call<ResetPasswordResponse>, t: Throwable) {
                    Toast.makeText(applicationContext, "OnFailure: ${t.message}", Toast.LENGTH_LONG)
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
                    call: Call<ResetPasswordResponse>,
                    response: Response<ResetPasswordResponse>
                ) {
                    if(response.isSuccessful){
                        Toast.makeText(applicationContext, response.message(), Toast.LENGTH_LONG)
                            .show()

                        //go to the next activity, which is the login page.
                        val intentLoginActivity= Intent(this@EnterVerification, LoginActivity::class.java)
                        startActivity(intentLoginActivity)
                    }
                }

            })

    }
}