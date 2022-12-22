package com.softsquared.template.kotlin.src.main.myPage.models

import com.google.gson.annotations.SerializedName

data class UserNameResult(
    @SerializedName("nickName") val nickName: String
)
