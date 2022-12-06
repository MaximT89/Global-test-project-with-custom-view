package com.max.secondworld.globaltestprojectwithcustomview.ui.screens.first

import androidx.core.content.ContextCompat
import androidx.fragment.app.viewModels
import com.max.secondworld.globaltestprojectwithcustomview.R
import com.max.secondworld.globaltestprojectwithcustomview.core.bases.BaseFragment
import com.max.secondworld.globaltestprojectwithcustomview.databinding.FragmentFirstBinding

class FirstFragment : BaseFragment<FragmentFirstBinding, FirstViewModel>(FragmentFirstBinding::inflate) {
    override val viewModel: FirstViewModel by viewModels()

    override fun initView() = with(binding){

        ring.setColorPath(ContextCompat.getColor(requireActivity(), R.color.alice_blue))

    }

    override fun initObservers() {
    }
}