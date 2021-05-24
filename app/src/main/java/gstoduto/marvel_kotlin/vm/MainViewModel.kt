package gstoduto.marvel_kotlin.vm

import android.app.Application
import android.os.AsyncTask
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import gstoduto.marvel_kotlin.App
import gstoduto.marvel_kotlin.R
import gstoduto.marvel_kotlin.repository.model.Comic
import gstoduto.marvel_kotlin.repository.remote.communication.ComicDataResponse
import gstoduto.marvel_kotlin.repository.remote.communication.TimeStampProvider
import gstoduto.marvel_kotlin.repository.remote.service.MarvelService
import gstoduto.marvel_kotlin.ui.BaseViewModel
import gstoduto.marvel_kotlin.util.Error
import gstoduto.marvel_kotlin.util.HashCalculator
import gstoduto.marvel_kotlin.util.MarvelResult
import gstoduto.marvel_kotlin.util.Success
import kotlinx.coroutines.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import java.util.*
import javax.inject.Inject

class MainViewModel(application: Application) : BaseViewModel(application) {
    private val app: App = application as App
    var sucessApi = MutableLiveData<Boolean>()
    var listComics: MutableList<Comic> = ArrayList()
    @JvmField
    @Inject
    var retrofit: Retrofit? = null

    class Factory(private val application: App) : ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return MainViewModel(application) as T
        }

    }

    private fun calculateHash(
        timeStamp: String,
        privateKey: String,
        publicKey: String
    ): String {
        return hashCalculator!!.calculate(timeStamp, privateKey, publicKey)
    }

    fun loadComicsAPI() {
        viewModelScope.launch {
            val comicDataResponse = getDataAPI()

            if(comicDataResponse is Success) {
                sucessApi.postValue(true)
                updateComics(comicDataResponse.data?.data?.results!!)
            }

            if(comicDataResponse is Error) {
                sucessApi.postValue(false)
            }
        }
    }

    suspend fun getDataAPI() = withContext(Dispatchers.IO) {
        var res: MarvelResult<ComicDataResponse?> = try {
            timeStampProvider = TimeStampProvider()
            hashCalculator = HashCalculator()
            val timeStamp = timeStampProvider!!.timeStamp
            val hash =
                calculateHash(timeStamp, MarvelService.PRIVATE_KEY, MarvelService.PUBLIC_KEY)

            Success(
                retrofit!!.create(MarvelService::class.java).getComics(
                    MarvelService.DEFAULT_LIMIT.toLong(), timeStamp,
                    MarvelService.PUBLIC_KEY,
                    hash
                )?.execute()?.body()
            )

        } catch (e: Exception) {
            Error(e)
        }
        res

    }

    private fun updateComics(comicDataResponse: List<Comic>) {
        if (comicDataResponse != null) {
            for (item in comicDataResponse) {
                val comic = Comic()
                comic.id = item.id
                comic.description =
                    if (item.description == null) app.getString(R.string.description_null) else item.description
                comic.creators = item.creators
                comic.dates = item.dates
                comic.images = item.images
                comic.pageCount = item.pageCount
                comic.prices = item.prices
                comic.thumbnail = item.thumbnail
                comic.title = item.title
                listComics.add(comic)
            }
        }
    }

    companion object {
        private var hashCalculator: HashCalculator? = null
        private var timeStampProvider: TimeStampProvider? = null
    }

    init {
        app.appComponent.inject(this)
    }
}