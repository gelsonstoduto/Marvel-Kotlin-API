package gstoduto.marvel_kotlin.repository.model

import com.google.gson.annotations.SerializedName

/**
 * Comic Date model.
 */
class ComicDate {
    @SerializedName("type")
    var type: String? = null
        private set
    @SerializedName("date")
    var date: String? = null
        private set

    constructor() {}
    private constructor(type: String?, date: String?) {
        this.type = type
        this.date = date
    }

    /**
     * Builder class.
     */
    class Builder {
        private var type: String? = null
        private var date: String? = null
        fun setType(type: String?): Builder {
            this.type = type
            return this
        }

        fun setDate(date: String?): Builder {
            this.date = date
            return this
        }

        fun build(): ComicDate {
            return ComicDate(type, date)
        }
    }
}