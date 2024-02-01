package com.example.coursework4

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object NetworkClient {
    private const val KAKAO_BASE_URL = "https://dapi.kakao.com/"
    val kakaoRepository = KakaoRepository(createKakaoSearchService())

    private fun createKakaoSearchService(): KakaoSearchService {
        val interceptor = HttpLoggingInterceptor()
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)

        val client = OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .addInterceptor { chain ->
                val original = chain.request()
                val request = original.newBuilder()
                    .header("Authorization", "KakaoAK ${REST_API_KEY}") // Replace with your Kakao API key
                    .method(original.method, original.body)
                    .build()

                chain.proceed(request)
            }
            .build()

        val retrofit = Retrofit.Builder()
            .baseUrl(KAKAO_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()

        return retrofit.create(KakaoSearchService::class.java)
    }
}



//object NetworkClient {
//    private const val KAKAO_BASE_URL = "https://dapi.kakao.com/"
//    val kakaoRepository = KakaoRepository(createOkHttpClient())
//    private fun createOkHttpClient(): OkHttpClient {
//        val interceptor = HttpLoggingInterceptor()
//
//
//            interceptor.level = HttpLoggingInterceptor.Level.BODY
//
//
//        return OkHttpClient.Builder()
//            .connectTimeout(20, TimeUnit.SECONDS)
//            .readTimeout(20, TimeUnit.SECONDS)
//            .writeTimeout(20, TimeUnit.SECONDS)
//            .addNetworkInterceptor(interceptor)
//            .build()
//
//    }
//
//    private val kakaoRetrofit = Retrofit.Builder()
//        .baseUrl(KAKAO_BASE_URL)
//        .addConverterFactory(GsonConverterFactory.create())
//        .client(createOkHttpClient())
//        .build()
//
//    val kakaoSearchService: KakaoSearchService =
//        kakaoRetrofit.create(KakaoSearchService::class.java)
//
//}


