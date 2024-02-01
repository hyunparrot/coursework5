package com.example.coursework4

import android.os.Bundle
import android.util.Log
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.coursework4.databinding.ActivityMainBinding
import com.example.coursework4.databinding.FragmentGalleryBinding
import com.example.coursework4.databinding.FragmentImageSearchBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: ItemAdapter
    private val viewModel: MainViewModel by viewModels()
    private lateinit var searchFragment: ImageSearchFragment
    private lateinit var galleryFragment: GalleryFragment

    val repository = NetworkClient.kakaoRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        searchFragment = ImageSearchFragment()
        galleryFragment = GalleryFragment()
        showSearchFragment()

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        val searchButton = binding.tvButton
        val searchEditText = binding.editTextSearch

        val galleryBinding = FragmentGalleryBinding.inflate(layoutInflater)
        val imageSearchBinding = FragmentImageSearchBinding.inflate(layoutInflater)

        galleryBinding.tvGallery.text = "내 보관함"
        imageSearchBinding.tvImageSearch.text = "이미지 검색"

        val galleryFragment = GalleryFragment()
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.frameLayoutGallery, galleryFragment)
            addToBackStack(null)
            commit()
        }
        val ImageSearchFragment = ImageSearchFragment()
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.frameLayoutImageSearch, ImageSearchFragment)
            addToBackStack(null)
            commit()
        }

//  위의 코드로 하니까 되고 아래 코드로 하면 안됨. 수정 필요.

//        galleryBinding.tvGallery.setOnClickListener {
//            supportFragmentManager.beginTransaction().apply {
//                replace(R.id.frameLayoutGallery, GalleryFragment())
//                addToBackStack(null)
//                commit()
//            }
//        }
//
//        imageSearchBinding.tvImageSearch.setOnClickListener {
//            supportFragmentManager.beginTransaction().apply {
//                replace(R.id.frameLayoutImageSearch, ImageSearchFragment())
//                addToBackStack(null)
//                commit()
//            }
//        }

        searchButton.setOnClickListener {
            val query = searchEditText.text.toString().trim()
            if (query.isNotEmpty()) {
                // 검색어가 비어있지 않으면 검색 기능 실행
                performSearch(query)
            } else {
                Toast.makeText(this, "검색어를 입력하세요", Toast.LENGTH_SHORT).show()
            }
        }

        recyclerView = binding.recyclerView
        adapter = ItemAdapter(mutableListOf()) // 여기에 데이터를 전달 함.

        recyclerView.adapter = adapter
        recyclerView.layoutManager = GridLayoutManager(this, 2)

        val mainViewModelFactory = MainViewModelFactory(application, repository)
        val viewModel = ViewModelProvider(this, mainViewModelFactory).get(MainViewModel::class.java)

        viewModel.kakaoData.observe(this) { response ->

            val documents = response.kakaoDocuments
            documents?.let {
                adapter.setItems(documents)
            }
        }


        // 데이터를 가져오는 함수 호출
        viewModel.loadData()
    }

    private fun performSearch(query: String) {
        // 여기에서 검색을 실행하고 결과를 리사이클러뷰에 표시하는 코드를 작성
        viewModel.searchImages(query)
    }
    private fun showSearchFragment() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.frameLayoutImageSearch, searchFragment)
            .commit()
    }

    private fun showGalleryFragment() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.detailMainFragment, galleryFragment)
            .commit()
    }
}