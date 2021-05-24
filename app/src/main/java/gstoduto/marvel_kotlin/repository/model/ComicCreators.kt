package gstoduto.marvel_kotlin.repository.model

import com.google.gson.annotations.SerializedName

/**
 * Comic Creators item model.
 */
class ComicCreators {
    @SerializedName("available")
    var available = 0
    @SerializedName("collectionURI")
    var collectionUri: String? = null
    @SerializedName("items")
    var items: List<CreatorSummary>? = null

}