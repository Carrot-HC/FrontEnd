package com.softsquared.template.kotlin.src.main.home.models

import com.google.gson.annotations.SerializedName

data class HomeRequest(
    @SerializedName("userIdx") val userIdx: Int
)
