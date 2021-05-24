package gstoduto.marvel_kotlin.repository.remote.communication

import com.google.gson.annotations.SerializedName
import gstoduto.marvel_kotlin.repository.model.Comic

/**
 * Comic Data Content.
 */
class ComicData {
    @SerializedName("count")
    val count = 0
    @SerializedName("total")
    val total = 0
    @SerializedName("results")
    val results: List<Comic>? = null

}