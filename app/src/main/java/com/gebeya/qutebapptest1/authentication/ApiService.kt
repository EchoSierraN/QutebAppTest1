package com.gebeya.qutebapptest1.authentication

import com.gebeya.qutebapptest1.model.*
import retrofit2.Call
import retrofit2.http.*

/**
 * Interface for defining REST request functions
 */

interface ApiService {

    //region REST REQUEST FUNCTIONS

    @POST(Constants.LOGIN_URL)
    fun login(@Body request: LoginRequest): Call<LoginResponse>

    @POST(Constants.SIGNUP_URL)
    fun signup(@Body request: SignupRequest): Call<SignupResponse>

    @POST(Constants.PASSWORD_RESET_REQUEST_CODE_URL)
    fun passwordResetCodeRequest(@Body request: PasswordResetCodeRequest): Call<PasswordResetCodeResponse>

    @PATCH(Constants.PASSWORD_RESET_REQUEST_URL)
    fun resetPasswordRequest(@Body request: ResetPasswordRequest): Call<ResetPasswordResponse>

    @GET(Constants.GET_ALL_SPENDINGS_URL)
    fun getAllSpendingsRequest(): Call<List<SpendingResponse>>
//    fun getAllSpendingsRequest(@Body allSpendingsRequest: AllSpendingsRequest): Call<List<SpendingResponse>>

//    @GET("api/user/v1")
//    fun test(): Call<Any>

    //region REST FUNCTIONS: DashboardSpendingFragment


    //endregion

    //endregion

}

//    @GET(Constants.POSTS_URL)
//    fun fetchPosts(): Call<PostsResponse>
