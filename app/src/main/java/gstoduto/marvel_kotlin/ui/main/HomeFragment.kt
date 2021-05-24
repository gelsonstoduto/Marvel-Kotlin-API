package gstoduto.marvel_kotlin.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import gstoduto.marvel_kotlin.R
import gstoduto.marvel_kotlin.adapter.ComicAdapter
import gstoduto.marvel_kotlin.dialogs.AppDialogGeneric
import gstoduto.marvel_kotlin.repository.model.Comic
import gstoduto.marvel_kotlin.ui.BaseFragment
import gstoduto.marvel_kotlin.ui.BaseViewModel
import gstoduto.marvel_kotlin.vm.MainViewModel
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_home.view.*
import java.util.*

class HomeFragment : BaseFragment() {
    private lateinit var vm: MainViewModel
    private lateinit var adapter: ComicAdapter
    private lateinit var comics: List<Comic>
    private lateinit var mLayoutManagerMyComics: LinearLayoutManager

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return setViews(inflater.inflate(R.layout.fragment_home, container, false))
    }

    private fun getMainVM(): MainViewModel {return getViewModel()}

    private fun setViews(v: View): View {
        v.pBarComic.visibility = View.VISIBLE
        return v
    }

    private fun loadMarvelComics() {
        rv_comics.setHasFixedSize(true)
        mLayoutManagerMyComics =
            object : LinearLayoutManager(context, VERTICAL, false) {}
        rv_comics.layoutManager = mLayoutManagerMyComics
        comics = ArrayList()
        adapter = ComicAdapter(vm.listComics, this)
        rv_comics.adapter = adapter
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        vm = getMainVM()
        setObservers()
    }

    private fun setObservers() {
        vm.sucessApi.observe(
            this,
            Observer { sucesso: Boolean ->
                if (sucesso) {
                    loadMarvelComics()
                    pBarComic.visibility = View.INVISIBLE
                } else {
                    val appDialogGeneric = AppDialogGeneric(
                        getActivity()!!.application.getString(R.string.message_ops),
                        getActivity()!!.application.getString(R.string.message_api_error)
                    )
                    appDialogGeneric.show(getActivity()!!.supportFragmentManager, "genericApp")
                }
            }
        )
    }

    override fun getViewModel(): MainViewModel {
        return ViewModelProviders
            .of(activity, MainViewModel.Factory(app))
            .get(MainViewModel::class.java)
    }

    companion object {
        fun newInstance(): Fragment {
            return HomeFragment()
        }
    }
}