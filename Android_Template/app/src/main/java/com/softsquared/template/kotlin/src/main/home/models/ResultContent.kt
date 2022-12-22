package com.softsquared.template.kotlin.src.main.home.models

import com.google.gson.annotations.SerializedName

data class ResultContent(
    @SerializedName("nickName") val nickName: String,
    @SerializedName("sellertown") val sellertown: String,
    @SerializedName("mannerTemp") val mannerTemp: Float,
    @SerializedName("title") val title: String,
    @SerializedName("productTown") val productTown: String,
    @SerializedName("updateAt") val updateAt: String,
    @SerializedName("content") val content: String,
    @SerializedName("image") val image: List<String>,
    @SerializedName("interestCount") val interestCount: Int,
    @SerializedName("price") val price: Int,
    @SerializedName("interest") val interest: String,
)
