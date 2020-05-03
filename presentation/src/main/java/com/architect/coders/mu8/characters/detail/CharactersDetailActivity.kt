package com.architect.coders.mu8.characters.detail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.architect.coders.mu8.R
import com.architect.coders.mu8.di.internal.ViewModelComponent
import com.architect.coders.mu8.di.internal.ViewModelModule
import com.architect.coders.mu8.databinding.ActivityCharactersDetailBinding
import com.architect.coders.mu8.utils.app
import com.architect.coders.mu8.utils.getViewModel
import com.architect.coders.mu8.utils.snackbar
import com.architect.codes.mu8.comics.Comic

class CharactersDetailActivity : AppCompatActivity() {

    private lateinit var component: ViewModelComponent
    private lateinit var binding: ActivityCharactersDetailBinding
    private lateinit var adapter: CharacterDetailAdapter

    private val viewModel by lazy { getViewModel { component.charactersDetailViewModel } }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_characters_detail)
        component = app.component.plus(ViewModelModule())

        initViewModel(intent.getLongExtra(CHARACTER, DEFAULT_CHARACTER_ID))
        initRecycler()
        observerViewModel()
    }

    private fun observerViewModel() {
        viewModel.comicsForCharacter.observe(this, Observer(::updateRecycler))
        viewModel.messageError.observe(this, Observer(::showMessage))
    }

    private fun updateRecycler(list: List<Comic>?) {
        adapter.comics = list.orEmpty()
    }

    private fun initRecycler() {
        adapter = CharacterDetailAdapter { }
        binding.recyclerComic.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        binding.recyclerComic.adapter = adapter
    }

    private fun initViewModel(characterId: Long) {
        viewModel.getDetailCharacter(characterId)
        binding.viewmodel = viewModel
        binding.lifecycleOwner = this
    }

    private fun showMessage(message: String) = binding.recyclerComic.snackbar(message)

    companion object {
        internal const val CHARACTER = "DetailActivity:Character"
        private const val DEFAULT_CHARACTER_ID: Long = -1
    }
}
