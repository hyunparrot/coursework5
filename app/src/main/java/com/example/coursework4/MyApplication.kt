package com.example.coursework4

import android.app.Application

class MyApplication : Application() {

    lateinit var kakaoRepository: KakaoRepository

    override fun onCreate() {
        super.onCreate()

        // 여기에서 KakaoRepository를 초기화
        kakaoRepository = NetworkClient.kakaoRepository
    }
}