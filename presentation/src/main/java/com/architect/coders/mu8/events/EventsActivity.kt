package com.architect.coders.mu8.events

import android.os.Bundle
import android.view.View.GONE
import android.view.View.VISIBLE
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.architect.coders.mu8.R
import com.architect.coders.mu8.di.internal.ViewModelComponent
import com.architect.coders.mu8.di.internal.ViewModelModule
import com.architect.coders.mu8.events.EventsUiModel.Contect
import com.architect.coders.mu8.events.EventsUiModel.Loading
import com.architect.coders.mu8.events.EventsUiModel.Navegation
import com.architect.coders.mu8.utils.app
import com.architect.coders.mu8.utils.getViewModel

class EventsActivity : AppCompatActivity() {

    private val viewModel by lazy { getViewModel { component.eventsViewModel } }
    private val recyclerView: RecyclerView by lazy { findViewById<RecyclerView>(R.id.recycler) }
    private val progress: ProgressBar by lazy { findViewById<ProgressBar>(R.id.progress) }
    private val toolbar: Toolbar by lazy { findViewById<Toolbar>(R.id.toolbar) }

    private lateinit var component: ViewModelComponent
    private lateinit var adapter: EventsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_events)
        component = app.component.plus(ViewModelModule())

        setSupportActionBar(toolbar)

        val toolbarTitle = findViewById<TextView>(R.id.toolbar_title)
        toolbarTitle.text = getString(R.string.events_name)

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
