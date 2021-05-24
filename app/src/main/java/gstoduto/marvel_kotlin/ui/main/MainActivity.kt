package gstoduto.marvel_kotlin.ui.main

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import gstoduto.marvel_kotlin.App
import gstoduto.marvel_kotlin.R
import gstoduto.marvel_kotlin.ui.BaseActivity
import gstoduto.marvel_kotlin.vm.MainViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import okhttp3.Dispatcher

class MainActivity : BaseActivity() {
    override fun getBaseVM(): MainViewModel {
        return ViewModelProviders
            .of(this, MainViewModel.Factory(application as App))
            .get(MainViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        (viewModel as MainViewModel).loadComicsAPI()

        setFragment()
    }

    private fun setFragment() {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.content, HomeFragment.newInstance())
            .commit()
    }

    override fun onBackPressed() {
        super.onBackPressed()
    }

    companion object {
        fun start(context: Context) {
            val intent = Intent(context, MainActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION or Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
            context.startActivity(intent)
        }
    }
}
