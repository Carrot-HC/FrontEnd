package com.softsquared.template.kotlin.src.main.myPage

import com.softsquared.template.kotlin.src.main.myPage.models.UserProfileResponse

interface ProfileActivityInterface {

    fun onGetUserProfileSuccess(response: UserProfileResponse)

    fun onGetUserProfileFailure(message: String)

}