package com.softsquared.template.kotlin.src.main.home

import com.softsquared.template.kotlin.src.main.home.models.HomeRequest
import com.softsquared.template.kotlin.src.main.home.models.HomeResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface HomeRetrofitInterface {
    @GET("/product/{userIdx}")
    fun getHome(@Path("userIdx") userIdx: Int) : Call<HomeResponse>

}
