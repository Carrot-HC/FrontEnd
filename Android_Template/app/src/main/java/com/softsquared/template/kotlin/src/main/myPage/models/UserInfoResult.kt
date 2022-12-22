package com.softsquared.template.kotlin.src.main.myPage.models

import com.google.gson.annotations.SerializedName

data class UserInfoResult(
    @SerializedName("nickName") val nickName: String,
    @SerializedName("joinDate") val joinDate: String,
    @SerializedName("mannerTemp") val mannerTemp: Float,
    @SerializedName("profileUrl") val profileUrl: String,
    @SerializedName("reTradingHope") val reTradingHope: Float,
    @SerializedName("responseRate") val responseRate: Float
)
