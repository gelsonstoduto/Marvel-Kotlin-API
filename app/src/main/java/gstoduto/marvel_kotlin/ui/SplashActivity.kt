package gstoduto.marvel_kotlin.ui

import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import gstoduto.marvel_kotlin.R
import gstoduto.marvel_kotlin.ui.main.MainActivity.Companion.start

class SplashActivity : AppCompatActivity() {
    var runMain = MutableLiveData<Boolean>()
    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash_activity)
        setObservers()
        val handler = Handler()
        handler.postDelayed({ runMain.value = true }, 3000)
    }

    private fun setObservers() {
        runMain.observe(
            this,
            Observer { s: Boolean? ->
                start(this)
            }
        )
    }
}