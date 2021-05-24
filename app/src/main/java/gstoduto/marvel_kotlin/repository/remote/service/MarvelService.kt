package gstoduto.marvel_kotlin.repository.remote.service

import android.database.Observable
import gstoduto.marvel_kotlin.repository.remote.communication.ComicDataResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MarvelService {
    @GET("comics/{comicId}")
    fun getComic(
        @Path("comicId") comicId: Long,
        @Query("ts") timeStamp: String?,
        @Query("apikey") apiKey: String?,
        @Query("hash") hash: String?
    ): Observable<ComicDataResponse?>?

    @GET("comics")
    fun getComics(
        @Query("limit") limit: Long,
        @Query("ts") timeStamp: String?,
        @Query("apikey") apiKey: String?,
        @Query("hash") hash: String?
    ): Call<ComicDataResponse?>?

    companion object {
        const val BASE_URL = "http://gateway.marvel.com/v1/public/"
        const val PUBLIC_KEY = gstoduto.marvel_kotlin.BuildConfig.PUBLIC_API_KEY
        const val PRIVATE_KEY = gstoduto.marvel_kotlin.BuildConfig.PRIVATE_API_KEY
        const val DEFAULT_LIMIT = 100
    }
}