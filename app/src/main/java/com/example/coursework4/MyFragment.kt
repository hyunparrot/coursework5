package com.example.coursework4

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels

class MyFragment : Fragment() {

    private val viewModel: MainViewModel by viewModels {
        MainViewModelFactory(requireActivity().application, (requireActivity().application as MyApplication).kakaoRepository)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // 특정 검색어와 함께 searchImages 호출
        viewModel.searchImages("")
    }
}