package com.architect.coders.mu8.ui.activity

import android.os.Bundle
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.architect.coders.mu8.R
import com.architect.coders.mu8.data.remote.repository.ComicRepository
import com.architect.coders.mu8.ui.adapter.ComicsAdapter
import com.architect.coders.mu8.ui.viewmodel.ComicsViewModel
import com.architect.coders.mu8.ui.viewmodel.ComicsViewModel.UiModel
import com.architect.coders.mu8.ui.viewmodel.ComicsViewModel.UiModel.*
import com.architect.coders.mu8.utils.getViewModel
import com.architect.coders.mu8.utils.makeItGone
import com.architect.coders.mu8.utils.makeItVisible
import com.architect.codes.mu8.interactor.comics.ComicsUseCase

class ComicActivity : AppCompatActivity() {

    private val progress: ProgressBar by lazy { findViewById<ProgressBar>(R.id.comic_activity_progress) }
    private val recycler: RecyclerView by lazy { findViewById<RecyclerView>(R.id.comic_activity_recycler) }

    private lateinit var viewModel: ComicsViewModel
    private lateinit var adapter: ComicsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_comic)

        viewModel = getViewModel {
            ComicsViewModel(
                ComicsUseCase(
                    ComicRepository()
                )
            )
        }

        adapter = ComicsAdapter(viewModel::onComicClicked)
        recycler.layoutManager = GridLayoutManager(this, 2)
        recycler.adapter = adapter
        viewModel.model.observe(this, Observer(::updateUi))
    }

    private fun updateUi(uiModel: UiModel) {
        when (uiModel) {
            is ShowLoading -> {
                progress.makeItVisible()
                recycler.makeItGone()
            }
            is LoadData -> {
                adapter.comics = uiModel.comics
                progress.makeItGone()
                recycler.makeItVisible()
            }
            is NavigateTo -> Toast.makeText(this, "click", Toast.LENGTH_LONG).show()
            // todo create comic detail
        }

    }

}
