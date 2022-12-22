package com.softsquared.template.kotlin.src.main.myPage.models

import com.google.gson.annotations.SerializedName

data class UserMannerReview(
    @SerializedName("mannerNum") val num: Int,
    @SerializedName("mannerComment") val comment: String
)
