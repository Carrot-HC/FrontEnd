package com.softsquared.template.kotlin.src.main.myPage

import android.util.Log
import com.softsquared.template.kotlin.config.ApplicationClass
import com.softsquared.template.kotlin.src.main.myPage.models.UserProfileResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProfileService(val profileActivityInterface: ProfileActivityInterface) {
    fun tryGetUserProfile(){
        val homeRetrofitInterface = ApplicationClass.sRetrofit.create(MyPageRetrofitInterface::class.java)
        homeRetrofitInterface.getUserProfile().enqueue(object : Callback<UserProfileResponse> {
            override fun onResponse(call: Call<UserProfileResponse>, response: Response<UserProfileResponse>) {
                Log.d("ProfileService", "success")
                Log.d("ProfileService", response.body().toString())
                profileActivityInterface.onGetUserProfileSuccess(response.body() as UserProfileResponse)
            }

            override fun onFailure(call: Call<UserProfileResponse>, t: Throwable) {
                Log.d("ProfileService", "fail")
                t.printStackTrace()
                profileActivityInterface.onGetUserProfileFailure(t.message ?: "통신 오류")
            }
        })
    }
}