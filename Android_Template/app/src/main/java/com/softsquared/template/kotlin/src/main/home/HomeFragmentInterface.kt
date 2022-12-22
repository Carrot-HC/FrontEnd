package com.softsquared.template.kotlin.src.main.home

import com.softsquared.template.kotlin.src.main.home.models.HomeResponse

interface HomeFragmentInterface {

    fun onGetHomeSuccess(response: HomeResponse)

    fun onGetHomeFailure(message: String)

}