package com.softsquared.template.kotlin.src.main.myPage

import com.softsquared.template.kotlin.src.main.myPage.models.UserNameResponse
import com.softsquared.template.kotlin.src.main.myPage.models.UserProfileResponse
import retrofit2.Call
import retrofit2.http.GET

interface MyPageRetrofitInterface {
    @GET("/user/info")
    fun getUserName() : Call<UserNameResponse>

    @GET("/user/profile")
    fun getUserProfile() : Call<UserProfileResponse>


//    @GET("/user/info")
//    fun getUserName(@Header("X-ACCESS-TOKEN") jwt: String) : Call<UserNameResponse>

//    @POST("/template/users")
//    fun postSignUp(@Body params: PostSignUpRequest): Call<SignUpResponse>

}