package com.architect.coders.mu8.characters.detail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.architect.coders.mu8.R
import com.architect.coders.mu8.data.DataApp
import com.architect.coders.mu8.data.characters.CharactersRepositoryImpl
import com.architect.coders.mu8.data.charactersDetail.CharacterDetailRepositoryImpl
import com.architect.coders.mu8.databinding.ActivityCharactersDetailBinding
import com.architect.coders.mu8.utils.getViewModel
import com.architect.codes.mu8.characters.CharactersUseCaseImpl
import com.architect.codes.mu8.charactersDetail.CharacterDetalUseCaseImpl
import com.architect.codes.mu8.comics.Comic

class CharactersDetailActivity : AppCompatActivity() {

    private val DEFAULT_CHARATER_ID: Long = -1
    private lateinit var viewModel: CharactersDetailViewModel
    private lateinit var binding: ActivityCharactersDetailBinding
    private lateinit var adapter: CharacterDetailAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_characters_detail)

        initViewModel(intent.getLongExtra(CHARACTER, DEFAULT_CHARATER_ID))
        initRecycler()
        viewModel.comicsForCharacter.observe(this, Observer(::updateRecycler))
    }

    private fun updateRecycler(list: List<Comic>?) {
        adapter.comics = list.orEmpty()
    }

    private fun initRecycler() {
        adapter = CharacterDetailAdapter { }
        binding.recyclerComic.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        binding.recyclerComic.adapter = adapter
    }

    private fun initViewModel(longExtra: Long) {
        viewModel = getViewModel {
            CharactersDetailViewModel(
                longExtra,
                CharacterDetalUseCaseImpl(CharacterDetailRepositoryImpl(application as DataApp)),
                CharactersUseCaseImpl(CharactersRepositoryImpl(application as DataApp))
            )
        }
        binding.viewmodel = viewModel
        binding.lifecycleOwner = this
    }

    companion object {
        const val CHARACTER = "DetailActivity:Character"
    }
}
