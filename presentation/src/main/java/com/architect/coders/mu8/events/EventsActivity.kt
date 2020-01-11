package com.architect.coders.mu8.events

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View.GONE
import android.view.View.VISIBLE
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.architect.coders.mu8.R
import com.architect.coders.mu8.data.events.EventsMapper
import com.architect.coders.mu8.data.events.EventsRepositoryImpl
import com.architect.coders.mu8.events.EventsUiModel.*
import com.architect.coders.mu8.utils.getViewModel
import com.architect.codes.mu8.events.EventsUserCaseImpl

class EventsActivity : AppCompatActivity() {

    private val recyclerView: RecyclerView by lazy { findViewById<RecyclerView>(R.id.recycler) }
    private val progress: ProgressBar by lazy { findViewById<ProgressBar>(R.id.progress) }
    private val toolbar: Toolbar by lazy { findViewById<Toolbar>(R.id.toolbar) }

    private lateinit var viewModel: EventsViewModel
    private lateinit var adapter: EventsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_events)

        setSupportActionBar(toolbar)

        val toolbarTitle = findViewById<TextView>(R.id.toolbar_title)
        toolbarTitle.text = getString(R.string.events_name)

        viewModel = getViewModel { EventsViewModel(EventsUserCaseImpl(EventsRepositoryImpl(EventsMapper()))) }

        adapter = EventsAdapter(viewModel::onEventClick)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        viewModel.model.observe(this, Observer(::updateUi))
    }

    private fun updateUi(model: EventsUiModel) {
        progress.visibility = if (model == Loading) VISIBLE else GONE

        when (model) {
            is Contect -> adapter.events = model.events
            is Navegation -> Toast.makeText(this, model.event.title, Toast.LENGTH_LONG).show()
        }
    }
}
