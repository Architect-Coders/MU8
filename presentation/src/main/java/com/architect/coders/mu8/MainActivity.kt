package com.architect.coders.mu8

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.architect.coders.mu8.CategoriesViewModel.UiModel
import com.architect.coders.mu8.data.local.categories.CategoriesRepository

class MainActivity : AppCompatActivity() {

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

        toolbarTitle = findViewById(R.id.toolbar_title)
        toolbarTitle.text = getString(R.string.app_name)

        recycler = findViewById(R.id.marvel_list)

        viewModel = ViewModelProviders.of(this,
            CategoriesViewModelFactory(CategoriesRepository())
        )[CategoriesViewModel::class.java]

        viewModel.model.observe(this, Observer(::updateUi))
    }

    private fun updateUi(model: UiModel) {
        when(model) {
            is UiModel.Content -> {
                adapter = CategoriesAdapter(viewModel::onMoviewClicked, model.categories)
                recycler.layoutManager = LinearLayoutManager(this)
                recycler.adapter = adapter
            }
            is UiModel.Navigation -> Toast.makeText(this, model.category.title, Toast.LENGTH_SHORT).show()
        }
    }
}
