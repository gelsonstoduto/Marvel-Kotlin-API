package gstoduto.marvel_kotlin

import android.app.Application
import gstoduto.marvel_kotlin.di.AppComponent
import gstoduto.marvel_kotlin.di.AppModule
import gstoduto.marvel_kotlin.di.DaggerAppComponent
import timber.log.Timber
import timber.log.Timber.DebugTree

class App : Application() {
    lateinit var appComponent: AppComponent
        private set

    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) Timber.plant(DebugTree())
        appComponent = DaggerAppComponent.builder().appModule(AppModule(this)).build()
    }

}