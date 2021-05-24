package gstoduto.marvel_kotlin.di

import gstoduto.marvel_kotlin.App
import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException

internal class DefaultParametersInterceptor(private val application: App) : Interceptor {
    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        return chain.proceed(request)
    }

}