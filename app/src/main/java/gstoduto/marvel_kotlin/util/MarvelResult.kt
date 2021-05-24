package gstoduto.marvel_kotlin.util

sealed class MarvelResult<out T>

// By using Nothing as T, Loading is a subtype of all NetworkResult<T>
object Loading: MarvelResult<Nothing>()

// Successful results are stored in data
data class Success<out T>(val data: T): MarvelResult<T>()

// By using Nothing as T, all NetworkError instances are a subtypes of all NetworkResults<T>
data class Error(val exception: Throwable): MarvelResult<Nothing>()
