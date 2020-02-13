package com.architect.coders.mu8.comics

import android.os.Bundle
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.architect.coders.mu8.R
import com.architect.coders.mu8.comics.ComicsViewModel.UiModel.InternetError
import com.architect.coders.mu8.comics.ComicsViewModel.UiModel.LoadData
import com.architect.coders.mu8.comics.ComicsViewModel.UiModel.NavigateTo
import com.architect.coders.mu8.comics.ComicsViewModel.UiModel.ShowLoading
import com.architect.coders.mu8.data.DataApp
import com.architect.coders.mu8.data.comics.ComicRepositoryImpl
import com.architect.coders.mu8.utils.getViewModel
import com.architect.coders.mu8.utils.makeItGone
import com.architect.coders.mu8.utils.makeItVisible
import com.architect.codes.mu8.comics.ComicsUseCaseImpl
import com.google.android.material.snackbar.Snackbar

class ComicsActivity : AppCompatActivity() {

    private val progress: ProgressBar by lazy { findViewById<ProgressBar>(R.id.comic_activity_progress) }
    private val recycler: RecyclerView by lazy { findViewById<RecyclerView>(R.id.comic_activity_recycler) }

    private lateinit var toolbar: Toolbar
    private lateinit var toolbarTitle: TextView
    private lateinit var viewModel: ComicsViewModel
    private lateinit var adapter: ComicsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_comics)

        toolbar = findViewById(R.id.comic_activity_toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)

        toolbarTitle = findViewById(R.id.toolbar_title)
        toolbarTitle.text = getString(R.string.comics_name)

        viewModel = getViewModel {
            ComicsViewModel(
                ComicsUseCaseImpl(
                    ComicRepositoryImpl(application as DataApp)
                )
            )
        }

        adapter = ComicsAdapter(viewModel::onComicClicked)
        recycler.layoutManager = GridLayoutManager(this, GRID_COLUMS)
        recycler.adapter = adapter

        viewModel.model.observe(this, Observer(::updateUi))
    }

    private fun updateUi(uiModel: ComicsViewModel.UiModel) {
        return when (uiModel) {
            is ShowLoading -> {
                progress.makeItVisible()
                recycler.makeItGone()
            }
            is LoadData -> {
                adapter.comics = uiModel.comics
                progress.makeItGone()
                recycler.makeItVisible()
            }
            is InternetError -> {
                progress.makeItGone()
                recycler.makeItGone()
                Snackbar.make(
                    recycler,
                    getString(R.string.error_internet_message),
                    Snackbar.LENGTH_LONG
                ).show()
            }
            is NavigateTo -> Toast.makeText(this, uiModel.comic.title, Toast.LENGTH_LONG).show()
        }
    }

    companion object {
        private const val GRID_COLUMS = 2
    }
}
