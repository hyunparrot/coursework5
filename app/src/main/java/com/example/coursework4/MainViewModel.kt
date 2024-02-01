package com.example.coursework4

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class MainViewModel(application: Application, private val repository: KakaoRepository) : AndroidViewModel(application) {

    private val _kakaoData = MutableLiveData<KakaoResponse>()
    val kakaoData: LiveData<KakaoResponse> get() = _kakaoData

    //    private val viewModel: MainViewModel by viewModels {
//        MainViewModelFactory(getApplication())
//    }
    fun searchImages(query: String) {
        Log.d("MainViewModel", "Searching images for: $query")
        viewModelScope.launch {

                val response = repository.searchImages(query)
                _kakaoData.postValue(response)

            }
        }



    fun loadData() {
        Log.d("MainViewModel", "Loading data")
        viewModelScope.launch {

                val response = repository.searchImages("parrot")
                _kakaoData.postValue(response)

        }
    }
}










