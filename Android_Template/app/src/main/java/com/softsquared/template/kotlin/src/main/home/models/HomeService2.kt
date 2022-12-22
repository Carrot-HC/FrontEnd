package com.softsquared.template.kotlin.src.main.home.models

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Header

interface HomeService2 {
    @GET("/product/{userIdx}")
    fun getHome(
        @Path("userIdx") userIdx: Int,
        @Header("X-ACCESS-TOKEN") token: String
    ) : Call<HomeResponse>
}