package com.softsquared.template.kotlin.src.main.townLife

import android.os.Bundle
import android.view.View
import com.softsquared.template.kotlin.R
import com.softsquared.template.kotlin.config.BaseFragment
import com.softsquared.template.kotlin.databinding.FragmentTownLifeBinding

class TownLifeFragment :
    BaseFragment<FragmentTownLifeBinding>(FragmentTownLifeBinding::bind, R.layout.fragment_town_life) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}