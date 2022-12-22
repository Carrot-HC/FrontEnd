package com.softsquared.template.kotlin.src.main.home

import android.util.Log
import com.softsquared.template.kotlin.config.ApplicationClass
import com.softsquared.template.kotlin.src.main.home.models.HomeResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeService(val homeFragmentInterface: HomeFragmentInterface) {

    fun tryGetHome(userIdx: Int){
        val homeRetrofitInterface = ApplicationClass.sRetrofit.create(HomeRetrofitInterface::class.java)
        homeRetrofitInterface.getHome(userIdx).enqueue(object : Callback<HomeResponse>{
            override fun onResponse(call: Call<HomeResponse>, response: Response<HomeResponse>) {
                Log.d("home", response.body().toString())
                homeFragmentInterface.onGetHomeSuccess(response.body() as HomeResponse)
            }

            override fun onFailure(call: Call<HomeResponse>, t: Throwable) {
                homeFragmentInterface.onGetHomeFailure(t.message ?: "통신 오류")
            }

        })


    }



}
