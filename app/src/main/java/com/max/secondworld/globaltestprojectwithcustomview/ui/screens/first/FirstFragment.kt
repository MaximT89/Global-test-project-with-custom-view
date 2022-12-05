package com.max.secondworld.globaltestprojectwithcustomview.ui.screens.first

import androidx.fragment.app.viewModels
import com.max.secondworld.globaltestprojectwithcustomview.core.bases.BaseFragment
import com.max.secondworld.globaltestprojectwithcustomview.databinding.FragmentFirstBinding

class FirstFragment : BaseFragment<FragmentFirstBinding, FirstViewModel>(FragmentFirstBinding::inflate) {
    override val viewModel: FirstViewModel by viewModels()

    override fun initView() {
    }

    override fun initObservers() {
    }
}