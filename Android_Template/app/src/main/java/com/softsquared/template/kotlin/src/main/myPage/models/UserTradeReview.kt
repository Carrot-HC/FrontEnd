package com.softsquared.template.kotlin.src.main.myPage.models

import com.google.gson.annotations.SerializedName

data class UserTradeReview(
    @SerializedName("tradeUserNickName") val name: String,
    @SerializedName("tradeUserImg") val img: String,
    @SerializedName("tradeUserInfo") val info: String,
    @SerializedName("tradeUserTown") val town: String,
    @SerializedName("tradeDate") val date: String,
    @SerializedName("review") val review: String
)
