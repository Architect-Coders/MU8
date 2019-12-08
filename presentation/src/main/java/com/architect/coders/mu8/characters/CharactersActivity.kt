package com.architect.coders.mu8.characters

import android.os.Bundle
import android.view.View.GONE
import android.view.View.VISIBLE
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.architect.coders.mu8.R
import com.architect.coders.mu8.characters.CharactersUiModel.Content
import com.architect.coders.mu8.characters.CharactersUiModel.Loading
import com.architect.coders.mu8.characters.CharactersUiModel.Navigation
import com.architect.coders.mu8.characters.detail.CharactersDetailActivity
import com.architect.coders.mu8.data.characters.CharactersMapper
import com.architect.coders.mu8.data.characters.CharactersRepositoryImpl
import com.architect.coders.mu8.data.mapper.common.UrlsMapper
import com.architect.coders.mu8.utils.getViewModel
import com.architect.coders.mu8.utils.startActivity
import com.architect.codes.mu8.characters.CharactersUseCaseImpl

class CharactersActivity : AppCompatActivity() {

    private val toolbar: Toolbar by lazy { findViewById<Toolbar>(R.id.toolbar) }
    private val progress: ProgressBar by lazy { findViewById<ProgressBar>(R.id.progress) }
    private val recycler: RecyclerView by lazy { findViewById<RecyclerView>(R.id.recycler) }

    private lateinit var viewModel: CharactersViewModel
    private lateinit var adapter: CharactersAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_characters)

        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)

        val toolbarTitle = findViewById<TextView>(R.id.toolbar_title)
        toolbarTitle.text = getString(R.string.characters_name)

        viewModel = getViewModel {
            CharactersViewModel(
                CharactersUseCaseImpl(
                    CharactersRepositoryImpl(CharactersMapper(UrlsMapper()))
                )
            )
        }

        adapter = CharactersAdapter(viewModel::onCharacterClicked)
        recycler.layoutManager = LinearLayoutManager(this)
        recycler.adapter = adapter

        viewModel.model.observe(this, Observer(::updateUi))
    }

    private fun updateUi(model: CharactersUiModel) {
        progress.visibility = if (model == Loading) VISIBLE else GONE

        when (model) {
            is Content -> {
                adapter.characters = model.characters
                progress.visibility = GONE
            }
            is Navigation -> startActivity<CharactersDetailActivity> {}
        }
    }
}
