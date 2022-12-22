package com.softsquared.template.kotlin.src.main.myPage.models

import com.google.gson.annotations.SerializedName
import com.softsquared.template.kotlin.config.BaseResponse

data class UserNameResponse(
    @SerializedName("result") val result: UserNameResult
) : BaseResponse()
