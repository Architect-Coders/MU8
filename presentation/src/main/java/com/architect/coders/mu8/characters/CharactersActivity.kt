package com.architect.coders.mu8.characters

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.architect.coders.mu8.R
import com.architect.coders.mu8.characters.detail.CharactersDetailActivity
import com.architect.coders.mu8.characters.di.CharactersViewModelComponent
import com.architect.coders.mu8.characters.di.CharactersViewModelModule
import com.architect.coders.mu8.databinding.ActivityCharactersBinding
import com.architect.coders.mu8.utils.EventObserver
import com.architect.coders.mu8.utils.app
import com.architect.coders.mu8.utils.getViewModel
import com.architect.coders.mu8.utils.startActivity

class CharactersActivity : AppCompatActivity() {

    private lateinit var component: CharactersViewModelComponent
    private lateinit var adapter: CharactersAdapter
    private lateinit var binding: ActivityCharactersBinding

    private val viewModel by lazy { getViewModel { component.charactersViewModel } }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_characters)
        component = app.component.plus(CharactersViewModelModule())

        initViewModel()
        initToolbar()
        initRecycler()

        viewModel.navigateToCharacter.observe(this, EventObserver { startActivity<CharactersDetailActivity> {
            putExtra(CharactersDetailActivity.CHARACTER, it)
        } })
    }

    private fun initViewModel() {
        binding.viewmodel = viewModel
        binding.lifecycleOwner = this
    }

    private fun initToolbar() {
        viewModel.setTitle(getString(R.string.characters_name))
    }

    private fun initRecycler() {
        adapter = CharactersAdapter(viewModel::onCharacterClicked)
        binding.recycler.layoutManager = LinearLayoutManager(this)
        binding.recycler.adapter = adapter

        with(viewModel.characters) {
            observe(this@CharactersActivity, Observer {
                value?.let {
                    adapter.characters = it
                }
            })
        }
    }
}
