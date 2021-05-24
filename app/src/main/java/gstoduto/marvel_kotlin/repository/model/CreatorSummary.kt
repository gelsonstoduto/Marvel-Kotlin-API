package gstoduto.marvel_kotlin.repository.model

import com.google.gson.annotations.SerializedName

/**
 * Creator Summary model/\.
 */
class CreatorSummary {
    @SerializedName("name")
    var name: String? = null
        private set
    @SerializedName("role")
    var role: String? = null
        private set
    @SerializedName("resourceURI")
    var resourceUri: String? = null
        private set

    constructor() {}
    private constructor(name: String?, role: String?, resourceUri: String?) {
        this.name = name
        this.role = role
        this.resourceUri = resourceUri
    }

    /**
     * Builder class.
     */
    class Builder {
        private var name: String? = null
        private var role: String? = null
        private var resourceUri: String? = null
        fun setName(name: String?): Builder {
            this.name = name
            return this
        }

        fun setRole(role: String?): Builder {
            this.role = role
            return this
        }

        fun setResourceUri(resourceUri: String?): Builder {
            this.resourceUri = resourceUri
            return this
        }

        fun build(): CreatorSummary {
            return CreatorSummary(name, role, resourceUri)
        }
    }
}