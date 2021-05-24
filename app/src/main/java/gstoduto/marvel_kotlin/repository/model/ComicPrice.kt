package gstoduto.marvel_kotlin.repository.model

import com.google.gson.annotations.SerializedName

/**
 * Data class for a price item.
 */
class ComicPrice : Comparable<ComicPrice> {
    @SerializedName("type")
    var type: String? = null
        private set
    @SerializedName("price")
    var price = 0.0
        private set

    constructor() {}
    private constructor(type: String?, price: Double) {
        this.type = type
        this.price = price
    }

    override fun compareTo(otherPrice: ComicPrice): Int {
        return if (price > otherPrice.price) {
            1
        } else if (price < otherPrice.price) {
            -1
        } else {
            0
        }
    }

    /**
     * Builder class.
     */
    class Builder {
        private var type: String? = null
        private var price = 0.0
        fun setType(type: String?): Builder {
            this.type = type
            return this
        }

        fun setPrice(price: Double): Builder {
            this.price = price
            return this
        }

        fun build(): ComicPrice {
            return ComicPrice(type, price)
        }
    }
}