package com.softsquared.template.kotlin.src.main.chatting

import android.os.Bundle
import android.view.View
import com.softsquared.template.kotlin.R
import com.softsquared.template.kotlin.config.BaseFragment
import com.softsquared.template.kotlin.databinding.FragmentChattingBinding

class ChattingFragment :
    BaseFragment<FragmentChattingBinding>(FragmentChattingBinding::bind, R.layout.fragment_chatting) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}