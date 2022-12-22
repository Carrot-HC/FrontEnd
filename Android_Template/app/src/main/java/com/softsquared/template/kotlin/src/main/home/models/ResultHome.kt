package com.softsquared.template.kotlin.src.main.home.models

import com.google.gson.annotations.SerializedName

data class ResultHome(
    @SerializedName("userLocation") val userLocation: String,
    @SerializedName("productLists") val productLists : List<ResultProduct>
)
