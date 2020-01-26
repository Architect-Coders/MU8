package com.architect.coders.mu8.characters

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.architect.coders.mu8.R
import com.architect.coders.mu8.common.NavigationFragment
import com.architect.coders.mu8.common.StartingNavHostActivity
import com.architect.coders.mu8.data.DataApp
import com.architect.coders.mu8.data.characters.CharactersRepositoryImpl
import com.architect.coders.mu8.utils.getViewModel
import com.architect.codes.mu8.characters.CharactersUseCaseImpl

class CharactersFragment : NavigationFragment(R.id.action_charactersFragment_to_categoriesFragment) {

    private lateinit var recycler: RecyclerView
    private lateinit var progress: ProgressBar

    private lateinit var viewModel: CharactersViewModel
    private lateinit var adapter: CharactersAdapter

    private lateinit var navigationController: NavController

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.fragment_loader_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val navHostActivity = activity as StartingNavHostActivity
        navHostActivity.setToolbarTitle(getString(R.string.characters_name))

        navigationController = view.findNavController()

        viewModel = getViewModel {
            CharactersViewModel(CharactersUseCaseImpl(CharactersRepositoryImpl(navHostActivity.application as DataApp)))
        }

        adapter = CharactersAdapter(viewModel::onCharacterClicked)

        progress = view.findViewById(R.id.progress)

        recycler = view.findViewById(R.id.recycler)
        recycler.layoutManager = LinearLayoutManager(context)
        recycler.adapter = adapter

        viewModel.model.observe(this, Observer(::updateUi))
    }

    private fun updateUi(model: CharactersUiModel) {
        val context = this.context ?: return

        progress.visibility = if (model == CharactersUiModel.Loading) View.VISIBLE else View.GONE

        when (model) {
            is CharactersUiModel.Content -> {
                adapter.characters = model.characters
                progress.visibility = View.GONE
            }
            is CharactersUiModel.Navigation -> Toast.makeText(context, model.character.name, Toast.LENGTH_LONG).show()
        }
    }
}