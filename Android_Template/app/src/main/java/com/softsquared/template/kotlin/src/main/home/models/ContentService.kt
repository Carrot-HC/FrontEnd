package com.softsquared.template.kotlin.src.main.home.models

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path
import retrofit2.http.Query

interface ContentService {
    @GET("/product/{userIdx}/detail")
    fun getContent(
        @Path("userIdx") userIdx: Int,
        @Header("X-ACCESS-TOKEN") token: String,
        @Query("productIdx") productIdx: Int
    ) : Call<ContentResponse>
}