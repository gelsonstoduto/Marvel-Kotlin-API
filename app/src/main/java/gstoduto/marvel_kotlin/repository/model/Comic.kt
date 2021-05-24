package gstoduto.marvel_kotlin.repository.model

import com.google.gson.annotations.SerializedName

/**
 * Comic item data model.
 */
class Comic {
    @SerializedName("id")
    var id: Long = 0
    @SerializedName("title")
    var title: String? = null
    @SerializedName("description")
    var description: String? = null
    @SerializedName("pageCount")
    var pageCount = 0
    @SerializedName("thumbnail")
    var thumbnail: Image? = null
    @SerializedName("images")
    var images: List<Image>? =
        null
    @SerializedName("prices")
    var prices: List<ComicPrice>? = null
    @SerializedName("creators")
    var creators: ComicCreators? = null
    @SerializedName("dates")
    var dates: List<ComicDate>? = null

}