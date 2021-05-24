package gstoduto.marvel_kotlin.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer

abstract class BaseActivity : AppCompatActivity() {
    lateinit var viewModel: BaseViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = getBaseVM()
        viewModel.loading.observe(
            this,
            Observer { it: Boolean? -> }
        )
    }

    abstract fun getBaseVM():BaseViewModel
}