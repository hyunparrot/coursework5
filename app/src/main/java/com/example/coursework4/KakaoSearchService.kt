package com.example.coursework4

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

const val REST_API_KEY = "910aa7609581390ef8254e370b7d7196"

interface KakaoSearchService {
    @Headers("Authorization: KakaoAK ${REST_API_KEY}")
    @GET("https://dapi.kakao.com/v2/search/image") //카카오 검색 주소
    suspend fun getImage(
        @Query("query") query: Map<String, String>,
        @Query("size") size:Int = 80
    ) : KakaoResponse
}


//const val REST_API_KEY = "910aa7609581390ef8254e370b7d7196"
//
//interface KakaoSearchService {
//    @Headers("Authorization: KakaoAK ${REST_API_KEY}")
//    @GET("https://dapi.kakao.com/v2/search/image") //카카오 검색 주소
//    suspend fun getImage(@QueryMap param: Map<String, String>): Response<Kakao>
//}
