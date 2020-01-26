package com.architect.coders.mu8.categories

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.architect.coders.mu8.R
import com.architect.coders.mu8.common.NavigationFragment
import com.architect.coders.mu8.common.StartingNavHostActivity
import com.architect.coders.mu8.data.categories.CategoriesRepository
import com.architect.coders.mu8.utils.getViewModel
import com.architect.codes.mu8.utils.CHARACTERS
import com.architect.codes.mu8.utils.COMICS
import com.architect.codes.mu8.utils.EVENTS
import com.architect.codes.mu8.utils.NOT_FOUND

class CategoriesFragment : NavigationFragment() {

    private lateinit var recycler: RecyclerView

    private lateinit var viewModel: CategoriesViewModel
    private lateinit var adapter: CategoriesAdapter

    private lateinit var navigationController: NavController
    private lateinit var callback: OnBackPressedCallback

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.fragment_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val navHostActivity = activity as StartingNavHostActivity
        navHostActivity.showToolbar()
        navHostActivity.setToolbarTitle(getString(R.string.app_name))

        navigationController = view.findNavController()

        viewModel = getViewModel { CategoriesViewModel(CategoriesRepository()) }

        adapter = CategoriesAdapter(viewModel::onCategoryClicked)

        recycler = view.findViewById(R.id.recycler)
        recycler.layoutManager = LinearLayoutManager(navHostActivity)
        recycler.adapter = adapter

        viewModel.model.observe(this, Observer(::updateUi))
    }

    private fun updateUi(model: CategoriesViewModel.UiModel) {
        val context = this.context ?: return
        when (model) {
            is CategoriesViewModel.UiModel.Content -> adapter.categories = model.categories
            is CategoriesViewModel.UiModel.Navigation -> {
                when (model.categoryName) {
                    CHARACTERS -> navigationController.navigate(R.id.action_categoriesFragment_to_charactersFragment)
                    COMICS -> navigationController.navigate(R.id.action_categoriesFragment_to_comicsFragment)
                    EVENTS -> navigationController.navigate(R.id.action_categoriesFragment_to_eventsFragment)
                    else -> Toast.makeText(context, NOT_FOUND, Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}