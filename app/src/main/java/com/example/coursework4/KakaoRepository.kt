package com.example.coursework4


import okhttp3.OkHttpClient
import retrofit2.Retrofit

class KakaoRepository(private val kakaoSearchService: KakaoSearchService) {

    suspend fun searchImages(query: String): KakaoResponse {
            // 검색에 필요한 쿼리 맵 구성
            val queryMap = mapOf(
                "query" to query,
                "size" to "80" // 예시로 이미지 10개만 가져오도록 설정
            )

            // KakaoSearchService의 getImage 함수를 호출하여 검색 결과를 받아옴
            val response = kakaoSearchService.getImage(queryMap)
            return response
        }


//    suspend fun searchImagesWithDetails(query: String): List<KakaoDocuments> {
//        val response = searchImages(query)
//        return response.kakaoDocuments.map { document ->
//            KakaoDocuments(
//                thumbnailUrl = document.thumbnailUrl,
//                displaySiteName = document.displaySiteName,
//                datetime = document.datetime
//            )
//        }
//    }
}







//
//            // HTTP 응답이 성공적인지 확인
////            return if (response.isSuccessful) {
//            // 검색 결과가 있으면 Result.Success로 성공 리턴
////                Result.Success(
////                    KakaoResponse(
////                        kakaoMeta = ?: throw NullPointerException("KakaoResponse body is null"),
////                        response.body()?.kakaoMeta
////                            ?: throw NullPointerException("KakaoMeta is null"),
////                        response.body()?.kakaoDocuments
////                            ?: throw NullPointerException("KakaoDocuments is null")
////                    )
////                )
////            } else {
//            // 검색 결과가 없거나 실패한 경우 Result.Failure로 실패 리턴
//            val error: String = response.errorBody()?.string() ?: "Unknown error"
//            Result.Failure(Exception(error))
//
//
////        } catch (e: Exception) {
////            // 네트워크 호출 등에서 예외가 발생한 경우 Result.Failure로 실패 리턴
////            Result.Failure(e)
////        }
//        }
//    }
//}

