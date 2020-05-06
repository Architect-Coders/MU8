package com.architect.coders.mu8.comics

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.architect.coders.mu8.R
import com.architect.coders.mu8.databinding.ActivityComicsBinding
import com.architect.coders.mu8.di.internal.ViewModelComponent
import com.architect.coders.mu8.di.internal.ViewModelModule
import com.architect.coders.mu8.utils.EventObserver
import com.architect.coders.mu8.utils.app
import com.architect.coders.mu8.utils.getViewModel
import com.architect.coders.mu8.utils.snackbar
import com.architect.coders.mu8.utils.toast
import com.architect.codes.mu8.comics.Comic

class ComicsActivity : AppCompatActivity() {

    private val recycler: RecyclerView by lazy { findViewById<RecyclerView>(R.id.comic_activity_recycler) }
    private val viewModel by lazy { getViewModel { component.comicsViewModel } }

    private lateinit var component: ViewModelComponent
    private lateinit var toolbar: Toolbar
    private lateinit var toolbarTitle: TextView
    private lateinit var adapter: ComicsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding: ActivityComicsBinding = DataBindingUtil.setContentView(this, R.layout.activity_comics)
        component = app.component.plus(ViewModelModule())

        binding.viewmodel = viewModel
        binding.lifecycleOwner = this

        configureToolbar()
        configureRecycler()
        observerViewModel()
    }

    private fun configureToolbar() {
        toolbar = findViewById(R.id.comic_activity_toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)

        toolbarTitle = findViewById(R.id.toolbar_title)
        toolbarTitle.text = getString(R.string.comics_name)
    }

    private fun configureRecycler() {
        adapter = ComicsAdapter(viewModel::onComicClicked)
        recycler.layoutManager = GridLayoutManager(this, GRID_COLUMNS)
        recycler.adapter = adapter
    }

    private fun observerViewModel() {
        viewModel.comics.observe(this, Observer(::showComics))
        viewModel.messageError.observe(this, Observer(::showMessage))
        viewModel.navigateTo.observe(this, EventObserver { comic -> toast(comic.title) })
    }

    private fun showComics(comics: List<Comic>) {
        adapter.comics = comics
    }

    private fun showMessage(message: String) = recycler.snackbar(message)

    companion object {
        private const val GRID_COLUMNS = 2
    }
}
