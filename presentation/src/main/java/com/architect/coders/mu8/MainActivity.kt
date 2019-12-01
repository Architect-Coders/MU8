package com.architect.coders.mu8

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.toolbar.*
import com.architect.coders.mu8.CategoriesViewModel.UiModel
import com.architect.coders.mu8.data.local.categories.CategoriesRepository

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: CategoriesViewModel
    private lateinit var adapter: CategoriesAdapter
    private val recycler by lazy { findViewById<RecyclerView>(R.id.marvel_list) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(toolbar)

        viewModel = ViewModelProviders.of(this,
            CategoriesViewModelFactory(CategoriesRepository())
        )[CategoriesViewModel::class.java]

        toolbar_title.text = getString(R.string.app_name)

        recycler.layoutManager = LinearLayoutManager(this)
        adapter = CategoriesAdapter(viewModel::onMoviewClicked)
        recycler.adapter = adapter

        viewModel.model.observe(this, Observer(::updateUi))

    }

    private fun updateUi(model: UiModel) {

        when(model) {
            is UiModel.Content -> adapter.updateCategories(model.categories)
            is UiModel.Navigation -> Toast.makeText(this, model.category.title, Toast.LENGTH_SHORT).show()
        }
    }
}
