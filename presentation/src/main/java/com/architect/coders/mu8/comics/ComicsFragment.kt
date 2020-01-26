package com.architect.coders.mu8.comics

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.architect.coders.mu8.R
import com.architect.coders.mu8.common.NavigationFragment
import com.architect.coders.mu8.common.StartingNavHostActivity
import com.architect.coders.mu8.data.comics.ComicRepositoryImpl
import com.architect.coders.mu8.data.comics.ComicsMapper
import com.architect.coders.mu8.utils.getViewModel
import com.architect.coders.mu8.utils.makeItGone
import com.architect.coders.mu8.utils.makeItVisible
import com.architect.codes.mu8.comics.ComicsUseCaseImpl
import com.google.android.material.snackbar.Snackbar

class ComicsFragment : NavigationFragment(R.id.action_comicsFragment_to_categoriesFragment) {

    private lateinit var recycler: RecyclerView
    private lateinit var progress: ProgressBar

    private lateinit var viewModel: ComicsViewModel
    private lateinit var adapter: ComicsAdapter

    private lateinit var navigationController: NavController

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.fragment_loader_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val navHostActivity = activity as StartingNavHostActivity
        navHostActivity.showToolbar()
        navHostActivity.setToolbarTitle(getString(R.string.comics_name))

        navigationController = view.findNavController()

        viewModel = getViewModel {
            ComicsViewModel(
                ComicsUseCaseImpl(
                    ComicRepositoryImpl(ComicsMapper())
                )
            )
        }

        adapter = ComicsAdapter(viewModel::onComicClicked)

        progress = view.findViewById(R.id.progress)

        recycler = view.findViewById(R.id.recycler)
        recycler.layoutManager = GridLayoutManager(context, GRID_COLUMNS)
        recycler.adapter = adapter

        viewModel.model.observe(this, Observer(::updateUi))
    }

    private fun updateUi(uiModel: ComicsViewModel.UiModel) {
        val context = this.context ?: return

        return when (uiModel) {
            is ComicsViewModel.UiModel.ShowLoading -> {
                progress.makeItVisible()
                recycler.makeItGone()
            }
            is ComicsViewModel.UiModel.LoadData -> {
                adapter.comics = uiModel.comics
                progress.makeItGone()
                recycler.makeItVisible()
            }
            is ComicsViewModel.UiModel.InternetError -> {
                progress.makeItGone()
                recycler.makeItGone()
                Snackbar.make(recycler, getString(R.string.error_internet_message), Snackbar.LENGTH_LONG).show()
            }
            is ComicsViewModel.UiModel.NavigateTo -> Toast.makeText(context, uiModel.comic.title, Toast.LENGTH_LONG).show()
        }
    }

    companion object {
        private const val GRID_COLUMNS = 2
    }
}
