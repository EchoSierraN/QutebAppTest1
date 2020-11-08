package com.gebeya.qutebapptest1.model

import com.google.gson.annotations.SerializedName
import java.util.*


//region ====CONTENT====

/*The contents of this post will be updated later on, depending on
* what data I'll be requesting.
* Pro tip: consider making a new data class for a new data pull before
* editing one already made and working for other areas*/

//endregion

//region ====USER====
data class User(
    @SerializedName("firstName")
    var firstName: String = "firstName",
    @SerializedName("email")
    var email: String = "email@gmail.com",
    @SerializedName("id")
    var id: String = "0"
)
//endregion

//region LOGIN
data class LoginRequest(
    @SerializedName("email")
    var email: String,
    @SerializedName("password")
    var password: String
)

data class LoginResponse(
    @SerializedName("fullName")
    var fullName: String,
    @SerializedName("id")
    var id: String,
    @SerializedName("email")
    var email: String,
    @SerializedName("expiration")
    var expiration: String,
    @SerializedName("token")
    var token: String
)
//endregion

//region SIGNUP
data class SignupRequest(
    @SerializedName("fullName")
    var fullName: String,
    @SerializedName("email")
    var email: String,
    @SerializedName("password")
    var password: String
)

//check the Date data type with back end developer
data class SignupResponse(
    @SerializedName("token")
    var token: String,
    @SerializedName("expiration")
    var expiration: String,
    @SerializedName("id")
    var id: Int,
    @SerializedName("fullName")
    var fullName: String,
    @SerializedName("email")
    var email: String
)
//endregion

//region PASSWORD RESET
data class PasswordResetCodeRequest(
    @SerializedName("email")
    var email: String
)

data class PasswordResetCodeResponse(
    @SerializedName("message")
    var message: String
)

/***************************************************/

data class ResetPasswordRequest(
    @SerializedName("email")
    var email: String,
    @SerializedName("code")
    var code: String,
    @SerializedName("newPassword")
    var newPassword: String
)

data class ResetPasswordResponse(
    @SerializedName("message")
    var message: String
)
//endregion

//region ====MISCELLANEOUS====
object Constants {
    const val BASE_URL = "https://qutebapp-api.apps.et6om.gebeya.co"
    const val LOGIN_URL = "api/auth/signin-Email"
    const val SIGNUP_URL = "api/auth/signup-Email"
    //const val POSTS_URL = "posts"

    const val PASSWORD_RESET_REQUEST_CODE_URL= "api/auth/password/sendpasswordresetcode"
    const val PASSWORD_RESET_REQUEST_URL= "api/auth/password/resetforgottenpassword"
}

object Prefs{

}
//endregion
