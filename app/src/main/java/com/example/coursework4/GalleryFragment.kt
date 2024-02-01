package com.example.coursework4

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.example.coursework4.databinding.FragmentGalleryBinding

class GalleryFragment : Fragment() {
    private var _binding: FragmentGalleryBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?

    ): View {
        // Initialize the binding object
        _binding = FragmentGalleryBinding.inflate(inflater, container, false)
        val view = binding.root

        // Use binding to access views
        binding.tvGallery.text = "내 보관함"

        binding.tvGallery.setOnClickListener {

            val containerId = R.id.detailFragmentContainer
            val detailFragment = DetailFragment()
            val transaction: FragmentTransaction = requireFragmentManager().beginTransaction()

            transaction.replace(containerId, detailFragment)
            transaction.addToBackStack(null)
            transaction.commit()
        }
        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}