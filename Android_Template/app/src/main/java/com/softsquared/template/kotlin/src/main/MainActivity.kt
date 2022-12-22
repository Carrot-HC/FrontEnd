package com.softsquared.template.kotlin.src.main

import android.os.Bundle
import com.softsquared.template.kotlin.R
import com.softsquared.template.kotlin.config.BaseActivity
import com.softsquared.template.kotlin.databinding.ActivityMainBinding
import com.softsquared.template.kotlin.src.main.chatting.ChattingFragment
import com.softsquared.template.kotlin.src.main.chatting.MyPageFragment
import com.softsquared.template.kotlin.src.main.home.HomeFragment
import com.softsquared.template.kotlin.src.main.location.LocationFragment
import com.softsquared.template.kotlin.src.main.townLife.TownLifeFragment

class MainActivity : BaseActivity<ActivityMainBinding>(ActivityMainBinding::inflate) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        supportFragmentManager.beginTransaction().replace(R.id.main_frm, HomeFragment()).commitAllowingStateLoss()

        binding.mainBtmNav.run {
            setOnItemSelectedListener { item ->
                when (item.itemId) {
                    R.id.menu_main_btm_nav_home -> {
                        supportFragmentManager.beginTransaction()
                            .replace(R.id.main_frm, HomeFragment())
                            .commitAllowingStateLoss()
                    }
                    R.id.menu_main_btm_nav_town_life -> {
                        supportFragmentManager.beginTransaction()
                            .replace(R.id.main_frm, TownLifeFragment())
                            .commitAllowingStateLoss()
                    }
                    R.id.menu_main_btm_nav_location -> {
                        supportFragmentManager.beginTransaction()
                            .replace(R.id.main_frm, LocationFragment())
                            .commitAllowingStateLoss()
                    }
                    R.id.menu_main_btm_nav_chatting -> {
                        supportFragmentManager.beginTransaction()
                            .replace(R.id.main_frm, ChattingFragment())
                            .commitAllowingStateLoss()
                    }
                    R.id.menu_main_btm_nav_my_page -> {
                        supportFragmentManager.beginTransaction()
                            .replace(R.id.main_frm, MyPageFragment())
                            .commitAllowingStateLoss()
                    }
                }
                true
            }
            selectedItemId = R.id.menu_main_btm_nav_home
        }
    }
}