package com.softsquared.template.kotlin.src.main.myPage.models

import com.google.gson.annotations.SerializedName

data class UserProfileResult(
    @SerializedName("userIdx") val userIdx: Int,
    @SerializedName("town") val town: String,
    @SerializedName("userInfo") val userInfo: UserInfoResult,
    @SerializedName("badgeNum") val badgeNum: Int,
    @SerializedName("sellingProductNum") val sellingProductNum: Int,
    @SerializedName("tradeReviewNum") val tradeReviewNum: Int,
    @SerializedName("mannerReviewList") val mannerReviewList: ArrayList<UserMannerReview>,
    @SerializedName("tradeReviewList") val tradeReviewList: ArrayList<UserTradeReview>
)
