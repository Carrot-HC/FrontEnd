package com.softsquared.template.kotlin.src.main.myPage

import com.softsquared.template.kotlin.src.main.myPage.models.UserNameResponse

interface MyPageFragmentInterface {

    fun onGetUserNameSuccess(response: UserNameResponse)

    fun onGetUserNameFailure(message: String)


}