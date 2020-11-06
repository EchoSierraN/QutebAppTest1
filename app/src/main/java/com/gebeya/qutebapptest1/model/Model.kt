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
    @SerializedName("key")
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
    @SerializedName("fullName")
    var fullName: String,
    @SerializedName("expiration")
    var expiration: String,
    @SerializedName("email")
    var email: String,
    @SerializedName("token")
    var token: String,
    @SerializedName("id")
    var id: Int
)
//endregion

//region ====MISCELLANEOUS====
object Constants {
    const val BASE_URL = "https://qutebapp-api.apps.et6om.gebeya.co/"
    const val LOGIN_URL = "api/auth/signin-Email"
    const val SIGNUP_URL = "api/auth/signup-Email"
    //const val POSTS_URL = "posts"
}

object Prefs{

}
//endregion
