package com.softsquared.template.kotlin.src.main.myPage

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.softsquared.template.kotlin.R
import com.softsquared.template.kotlin.config.BaseActivity
import com.softsquared.template.kotlin.databinding.ActivityProfileBinding
import com.softsquared.template.kotlin.src.main.myPage.models.UserMannerReview
import com.softsquared.template.kotlin.src.main.myPage.models.UserProfileResponse
import com.softsquared.template.kotlin.src.main.myPage.models.UserTradeReview


class ProfileActivity : BaseActivity<ActivityProfileBinding>(ActivityProfileBinding::inflate), ProfileActivityInterface {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // 유저 프로필 받아오기 (닉네임)
        ProfileService(this).tryGetUserProfile()

    }

    override fun onGetUserProfileSuccess(response: UserProfileResponse) {

        val temp = response.result.userInfo.mannerTemp
        val joinDate = response.result.userInfo.joinDate

        val year = joinDate.substring(0, 4)
        val month = joinDate.substring(5, 7)
        val day = joinDate.substring(8, 10)

        val manner = response.result.mannerReviewList
        val review = response.result.tradeReviewList

        // 리사이클러뷰
        val mannerList: ArrayList<UserMannerReview> = arrayListOf()
        val mannerAdapter = MannerRVAdapter(mannerList)
        binding.rvManner.adapter = mannerAdapter
        binding.rvManner.layoutManager = LinearLayoutManager(this)
        if (manner != null) {
            if (manner.isNotEmpty()) {
                mannerList.addAll(manner)
            }

            mannerAdapter.notifyDataSetChanged()
        }

        val reviewList: ArrayList<UserTradeReview> = arrayListOf()
        val reviewAdapter = ReviewRVAdapter(reviewList)
        binding.rvReview.adapter = reviewAdapter
        binding.rvReview.layoutManager = LinearLayoutManager(this)
        if (review != null) {
            if (review.isNotEmpty()) {
                reviewList.addAll(review)
            }

            reviewAdapter.notifyDataSetChanged()
        }

        // 닉네임
        binding.tvUsername.text = response.result.userInfo.nickName
        binding.tvUserIdx.text = "#" + response.result.userIdx.toString()

        // 매너 온도
        binding.tvManner.text = temp.toString() + "°C"
        binding.progressManner.setProgress((temp * 10).toInt())

        // 재거래희망률, 응답률
        binding.tvHeartPercent.text = response.result.userInfo.reTradingHope.toString() + "%"
        binding.tvReplyPercent.text = response.result.userInfo.responseRate.toString() + "%"

        // 동네, 가입일
        binding.tvTown.text = response.result.town
        binding.tvJoinDate.text = "(" + year + "년 " + month + "월 " + day + "일 가입)"

        // 활동 배지 개수
        binding.tvBadgeCnt.text = response.result.badgeNum.toString() + "개"

        // 판매 상품 개수
        binding.tvSellCount.text = response.result.sellingProductNum.toString() + "개"

        // 받은 거래 후기
        binding.tvRcvReviewCnt.text = response.result.tradeReviewNum.toString()

    }

    override fun onGetUserProfileFailure(message: String) {
        TODO("Not yet implemented")
    }
}