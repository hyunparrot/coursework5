package com.example.coursework4

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

//@Parcelize
//sealed class Kakao (
//    val response: KakaoResponse)




data class KakaoResponse(
//    val response: KakaoResponse?,
    @SerializedName("meta")
    val kakaoMeta: KakaoMeta,
    @SerializedName("documents")
    val kakaoDocuments: MutableList<KakaoDocuments>)


data class KakaoMeta(
    @SerializedName("total_count")
    val totalCount: Int,
    @SerializedName("pageable_count")
    val pageableCount: Int,
    @SerializedName("is_end")
    val isEnd: Boolean)



data class KakaoDocuments(
    val collection: String,
    @SerializedName("thumbnail_url")
    val thumbnailUrl: String,
    @SerializedName("image_url")
    val imageUrl: String,
    val width: Int,
    val height: Int,
    @SerializedName("display_sitename")
    val displaySiteName: String,
    @SerializedName("doc_url")
    val docUrl: String,
    val datetime: String)

data class ImageModel(
    val imageId: String,
    val imageUrl: String,
    var isLiked: Boolean = false
)
