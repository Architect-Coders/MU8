package com.architect.coders.mu8.ui.activity

import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.architect.coders.mu8.CategoriesAdapter
import com.architect.coders.mu8.CategoriesViewModel
import com.architect.coders.mu8.CategoriesViewModel.UiModel
import com.architect.coders.mu8.CategoriesViewModelFactory
import com.architect.coders.mu8.R
import com.architect.coders.mu8.data.local.categories.CategoriesRepository
import com.architect.coders.mu8.utils.startActivity
import com.architect.codes.mu8.CHARACTERS
import com.architect.codes.mu8.COMICS
import com.architect.codes.mu8.EVENTS

class CategoriesActivity : AppCompatActivity() {

    private lateinit var toolbar: Toolbar
    private lateinit var toolbarTitle: TextView
    private lateinit var recycler: RecyclerView

    private lateinit var viewModel: CategoriesViewModel
    private lateinit var adapter: CategoriesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_categories)

        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)

        toolbarTitle = findViewById(R.id.toolbar_title)
        toolbarTitle.text = getString(R.string.app_name)

        recycler = findViewById(R.id.marvel_list)

        viewModel = ViewModelProviders.of(
            this,
            CategoriesViewModelFactory(CategoriesRepository())
        )[CategoriesViewModel::class.java]

        viewModel.model.observe(this, Observer(::updateUi))
    }

    private fun updateUi(model: UiModel) = when (model) {
        is UiModel.Content -> {
            adapter = CategoriesAdapter(viewModel::onCategoryClicked, model.categories)
            recycler.layoutManager = LinearLayoutManager(this)
            recycler.adapter = adapter
        }
        is UiModel.Navigation -> {
            when(model.category.title){
                COMICS -> startActivity<ComicsActivity> {}
                CHARACTERS, EVENTS -> Toast.makeText(this, COMICS, Toast.LENGTH_SHORT).show()
                else -> Toast.makeText(this, COMICS, Toast.LENGTH_SHORT).show()
            }
        }
    }
}
