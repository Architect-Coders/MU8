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
import com.architect.coders.mu8.comics.ComicsActivity
import com.architect.coders.mu8.di.internal.ViewModelComponent
import com.architect.coders.mu8.di.internal.ViewModelModule
import com.architect.coders.mu8.events.EventsActivity
import com.architect.coders.mu8.utils.app
import com.architect.coders.mu8.utils.getViewModel
import com.architect.coders.mu8.utils.startActivity
import com.architect.codes.mu8.utils.CHARACTERS
import com.architect.codes.mu8.utils.COMICS
import com.architect.codes.mu8.utils.EVENTS
import com.architect.codes.mu8.utils.NOT_FOUND

class CategoriesActivity : AppCompatActivity() {

    private lateinit var component: ViewModelComponent
    private lateinit var toolbar: Toolbar
    private lateinit var toolbarTitle: TextView
    private lateinit var recycler: RecyclerView
    private lateinit var adapter: CategoriesAdapter

    private val viewModel by lazy { getViewModel { component.categoriesViewModelModule } }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_categories)
        component = app.component.plus(ViewModelModule())

        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)

        toolbarTitle = findViewById(R.id.toolbar_title)
        toolbarTitle.text = getString(R.string.app_name)

        recycler = findViewById(R.id.marvel_list)

        adapter = CategoriesAdapter(viewModel::onCategoryClicked)
        recycler.layoutManager = LinearLayoutManager(this)
        recycler.adapter = adapter

        viewModel.model.observe(this, Observer(::updateUi))
    }

    private fun updateUi(model: UiModel) {
        when (model) {
            is UiModel.Content -> {
                adapter.categories = model.categories
            }
            is UiModel.Navigation -> {
                when (model.categoryName) {
                    CHARACTERS -> startActivity<CharactersActivity> {}
                    COMICS -> startActivity<ComicsActivity> {}
                    EVENTS -> startActivity<EventsActivity> {}
                    else -> Toast.makeText(this, NOT_FOUND, Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}
