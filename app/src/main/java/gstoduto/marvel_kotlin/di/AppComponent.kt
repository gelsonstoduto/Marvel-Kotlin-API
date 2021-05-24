package gstoduto.marvel_kotlin.di

import dagger.Component
import gstoduto.marvel_kotlin.vm.MainViewModel
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {
    fun inject(mainViewModel: MainViewModel?)
}