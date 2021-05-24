package gstoduto.marvel_kotlin.repository.remote.communication

import com.google.gson.annotations.SerializedName

/**
 * Comic data response from the API call.
 */
class ComicDataResponse {
    @SerializedName("code")
    var code = 0
    @SerializedName("status")
    var status: String? = null
    @SerializedName("copyright")
    var copyright: String? = null
    @SerializedName("attributionText")
    var attributionText: String? = null
    @SerializedName("data")
    var data: ComicData? = null

}