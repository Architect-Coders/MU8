package com.architect.coders.mu8.categories

import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.architect.coders.mu8.R
import com.architect.coders.mu8.categories.CategoriesViewModel.UiModel
import com.architect.coders.mu8.characters.CharactersActivity
import com.architect.coders.mu8.data.local.categories.CategoriesRepository
import com.architect.coders.mu8.utils.getViewModel
import com.architect.coders.mu8.utils.startActivity
import com.architect.codes.mu8.CHARACTERS
import com.architect.codes.mu8.COMICS
import com.architect.codes.mu8.EVENTS
import com.architect.codes.mu8.NOT_FOUND

class CategoriesActivity : AppCompatActivity() {

    private lateinit var toolbar: Toolbar
    private lateinit var toolbarTitle: TextView
    private lateinit var recycler: RecyclerView

    private lateinit var viewModel: CategoriesViewModel
    private lateinit var adapter: CategoriesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)

        toolbarTitle = findViewById(R.id.toolbar_title)
        toolbarTitle.text = getString(R.string.app_name)

        recycler = findViewById(R.id.marvel_list)

        viewModel = getViewModel { CategoriesViewModel(CategoriesRepository()) }
        viewModel.model.observe(this, Observer(::updateUi))
    }

    private fun updateUi(model: UiModel) {
        when (model) {
            is UiModel.Content -> {
                adapter = CategoriesAdapter(viewModel::onCategoryClicked, model.categories)
                recycler.layoutManager = LinearLayoutManager(this)
                recycler.adapter = adapter
            }
            is UiModel.Navigation -> {
                when (model.categoryName) {
                    CHARACTERS -> startActivity<CharactersActivity> {}
                    COMICS -> Toast.makeText(this, COMICS, Toast.LENGTH_SHORT).show()
                    EVENTS -> Toast.makeText(this, EVENTS, Toast.LENGTH_SHORT).show()
                    else -> Toast.makeText(this, NOT_FOUND, Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}
