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
import com.architect.coders.mu8.data.comics.ComicRepositoryImpl
import com.architect.coders.mu8.data.comics.ComicsMapper
import com.architect.coders.mu8.databinding.ActivityComicsBinding
import com.architect.coders.mu8.utils.EventObserver
import com.architect.coders.mu8.utils.getViewModel
import com.architect.coders.mu8.utils.toast
import com.architect.codes.mu8.comics.Comic
import com.architect.codes.mu8.comics.ComicsUseCaseImpl
import com.google.android.material.snackbar.Snackbar

class ComicsActivity : AppCompatActivity() {

    private val recycler: RecyclerView by lazy { findViewById<RecyclerView>(R.id.comic_activity_recycler) }

    private lateinit var toolbar: Toolbar
    private lateinit var toolbarTitle: TextView
    private lateinit var viewModel: ComicsViewModel
    private lateinit var adapter: ComicsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding: ActivityComicsBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_comics)

        viewModel = getViewModel {
            ComicsViewModel(
                ComicsUseCaseImpl(
                    ComicRepositoryImpl(ComicsMapper())
                )
            )
        }

        binding.viewmodel = viewModel
        binding.lifecycleOwner = this

        toolbar = findViewById(R.id.comic_activity_toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)

        toolbarTitle = findViewById(R.id.toolbar_title)
        toolbarTitle.text = getString(R.string.comics_name)

        adapter = ComicsAdapter(viewModel::onComicClicked)
        recycler.layoutManager = GridLayoutManager(this, GRID_COLUMS)
        recycler.adapter = adapter

        viewModel.comics.observe(this, Observer(::showComics))
        viewModel.messageError.observe(this, Observer(::showMessages))
        viewModel.navegateTo.observe(this, EventObserver { comic ->
            toast(comic.title)
        })
    }


    private fun showComics(comics: List<Comic>) {
        adapter.comics = comics
    }

    private fun showMessages(message: String) {
        Snackbar.make(recycler, message, Snackbar.LENGTH_LONG).show()
    }

    companion object {
        private const val GRID_COLUMS = 2
    }
}
