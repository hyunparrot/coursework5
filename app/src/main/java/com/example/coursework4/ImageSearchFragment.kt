package com.example.coursework4

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.coursework4.databinding.FragmentImageSearchBinding

class ImageSearchFragment : Fragment() {
    private var _binding: FragmentImageSearchBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Initialize the binding object
        _binding = FragmentImageSearchBinding.inflate(inflater, container, false)
        val view = binding.root

        // Use binding to access views in fragment_image_search.xml
        binding.tvImageSearch.text = "이미지 검색"

        // Return the inflated view
        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}