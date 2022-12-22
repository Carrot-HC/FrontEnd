package com.softsquared.template.kotlin.src.main.home.models

import com.google.gson.annotations.SerializedName

data class ResultProduct(
    @SerializedName("productIdx") val productIdx: Int,
    @SerializedName("town") val town: String,
    @SerializedName("updateAt") val updateAt: String,
    @SerializedName("price") val price: Int,
    @SerializedName("title") val title: String,
    @SerializedName("interestCount") val interestCount: Int,
    @SerializedName("productPhotoAddress") val productPhotoAddress: String
)
