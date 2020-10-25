package com.gebeya.qutebapptest1.authentication

import com.gebeya.qutebapptest1.model.*
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

/**
 * Interface for defining REST request functions
 */

interface ApiService {

    //region REST REQUEST FUNCTIONS

    @POST(Constants.LOGIN_URL)
    //@FormUrlEncoded
    fun login(@Body request: LoginRequest): Call<LoginResponse>

    @POST(Constants.SIGNUP_URL)
    fun signup(@Body request: SignupRequest): Call<SignupResponse>

//    @GET(Constants.POSTS_URL)
//    fun fetchPosts(): Call<PostsResponse>


    //endregion

}
