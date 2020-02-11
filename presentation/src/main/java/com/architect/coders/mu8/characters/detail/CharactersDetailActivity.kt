package com.architect.coders.mu8.characters.detail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.architect.coders.mu8.R
import com.architect.coders.mu8.data.DataApp
import com.architect.coders.mu8.data.charactersDetail.CharacterDetailRepositoryImpl
import com.architect.coders.mu8.databinding.ActivityCharactersDetailBinding
import com.architect.coders.mu8.utils.getViewModel
import com.architect.codes.mu8.charactersDetail.CharacterDetalUseCaseImpl

class CharactersDetailActivity : AppCompatActivity() {

    private lateinit var viewModel: CharactersDetailViewModel
    private lateinit var binding: ActivityCharactersDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_characters_detail)

        initVM(intent.getLongExtra(CHARACTER, -1))
    }

    private fun initVM(longExtra: Long) {
        viewModel = getViewModel {
            CharactersDetailViewModel(longExtra, CharacterDetalUseCaseImpl(CharacterDetailRepositoryImpl(application as DataApp)))
        }
        binding.viewmodel = viewModel
        binding.lifecycleOwner = this
    }

    companion object {
        const val CHARACTER = "DetailActivity:Character"
    }
}
