package com.softsquared.template.kotlin.src.main.chatting

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import com.softsquared.template.kotlin.R
import com.softsquared.template.kotlin.config.BaseFragment
import com.softsquared.template.kotlin.databinding.FragmentMyPageBinding
import com.softsquared.template.kotlin.src.main.myPage.MyPageFragmentInterface
import com.softsquared.template.kotlin.src.main.myPage.MyPageService
import com.softsquared.template.kotlin.src.main.myPage.ProfileActivity
import com.softsquared.template.kotlin.src.main.myPage.models.UserNameResponse

class MyPageFragment :
    BaseFragment<FragmentMyPageBinding>(FragmentMyPageBinding::bind, R.layout.fragment_my_page), MyPageFragmentInterface {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // 유저 정보 받아오기 (닉네임)
        MyPageService(this).tryGetUserName()

        // 프로필 보기 버튼
        binding.btnProfile.setOnClickListener{
            val intent = Intent(context, ProfileActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onGetUserNameSuccess(response: UserNameResponse) {
        // dismissLoadingDialog()
        binding.tvUsername.text = response.result.nickName
    }

    override fun onGetUserNameFailure(message: String) {
        Log.d("MyPageFragment", "fail")
    }
}