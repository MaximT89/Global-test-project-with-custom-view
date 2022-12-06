package com.max.secondworld.globaltestprojectwithcustomview.ui.screens.first

import androidx.fragment.app.viewModels
import com.max.secondworld.globaltestprojectwithcustomview.core.bases.BaseFragment
import com.max.secondworld.globaltestprojectwithcustomview.databinding.FragmentFirstBinding

class FirstFragment : BaseFragment<FragmentFirstBinding, FirstViewModel>(FragmentFirstBinding::inflate) {
    override val viewModel: FirstViewModel by viewModels()

    override fun initView() = with(binding){

        rect1.textTemperature(-40)


        rect2.textTemperature(-25)
        rect3.textTemperature(-10)
        rect4.textTemperature(5)
        rect5.textTemperature(10)
        rect6.textTemperature(20)
        rect7.textTemperature(38)
    }

    override fun initObservers() {
    }
}