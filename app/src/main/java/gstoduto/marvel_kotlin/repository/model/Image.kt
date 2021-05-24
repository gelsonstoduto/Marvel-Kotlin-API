package gstoduto.marvel_kotlin.repository.model

import com.google.gson.annotations.SerializedName

/**
 * Comic image model.
 */
class Image {
    @SerializedName("path")
    var path: String? = null
    @SerializedName("extension")
    var extension: String? = null

}