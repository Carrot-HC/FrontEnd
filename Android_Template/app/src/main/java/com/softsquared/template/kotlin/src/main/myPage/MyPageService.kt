package com.softsquared.template.kotlin.src.main.myPage

import android.util.Log
import com.softsquared.template.kotlin.config.ApplicationClass
import com.softsquared.template.kotlin.src.main.myPage.models.UserNameResponse
import com.softsquared.template.kotlin.src.main.myPage.models.UserProfileResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MyPageService(val myPageFragmentInterface: MyPageFragmentInterface) {

    fun tryGetUserName(){
        val homeRetrofitInterface = ApplicationClass.sRetrofit.create(MyPageRetrofitInterface::class.java)
        homeRetrofitInterface.getUserName().enqueue(object : Callback<UserNameResponse>{
            override fun onResponse(call: Call<UserNameResponse>, response: Response<UserNameResponse>) {
                Log.d("MyPageService", "success")
                Log.d("MyPageService", response.body().toString())
                myPageFragmentInterface.onGetUserNameSuccess(response.body() as UserNameResponse)
            }

            override fun onFailure(call: Call<UserNameResponse>, t: Throwable) {
                Log.d("MyPageService", "fail")
                t.printStackTrace()
                myPageFragmentInterface.onGetUserNameFailure(t.message ?: "통신 오류")
            }
        })
    }
}
