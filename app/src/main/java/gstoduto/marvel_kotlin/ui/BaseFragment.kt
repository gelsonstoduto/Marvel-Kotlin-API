package gstoduto.marvel_kotlin.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import gstoduto.marvel_kotlin.App
import gstoduto.marvel_kotlin.vm.MainViewModel

abstract class BaseFragment : Fragment() {
    protected lateinit var app: App
    protected lateinit var activity: BaseActivity
    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?
    ) {
        super.onViewCreated(view, savedInstanceState)
        app = getActivity()!!.application as App
        activity = getActivity() as BaseActivity
    }

    abstract fun getViewModel(): MainViewModel
}