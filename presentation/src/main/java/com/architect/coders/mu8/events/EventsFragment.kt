package com.architect.coders.mu8.events

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.architect.coders.mu8.R
import com.architect.coders.mu8.common.NavigationFragment
import com.architect.coders.mu8.common.StartingNavHostActivity
import com.architect.coders.mu8.data.events.EventsMapper
import com.architect.coders.mu8.data.events.EventsRepositoryImpl
import com.architect.coders.mu8.events.EventsUiModel.Contect
import com.architect.coders.mu8.events.EventsUiModel.Loading
import com.architect.coders.mu8.events.EventsUiModel.Navegation
import com.architect.coders.mu8.utils.getViewModel
import com.architect.codes.mu8.events.EventsUserCaseImpl

class EventsFragment : NavigationFragment(R.id.action_eventsFragment_to_categoriesFragment) {

    private lateinit var recycler: RecyclerView
    private lateinit var progress: ProgressBar

    private lateinit var viewModel: EventsViewModel
    private lateinit var adapter: EventsAdapter

    private lateinit var navigationController: NavController

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.fragment_loader_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val navHostActivity = activity as StartingNavHostActivity
        navHostActivity.setToolbarTitle(getString(R.string.events_name))

        navigationController = view.findNavController()

        viewModel = getViewModel { EventsViewModel(EventsUserCaseImpl(EventsRepositoryImpl(EventsMapper()))) }

        adapter = EventsAdapter(viewModel::onEventClick)

        progress = view.findViewById(R.id.progress)

        recycler = view.findViewById(R.id.recycler)
        recycler.layoutManager = LinearLayoutManager(context)
        recycler.adapter = adapter

        viewModel.model.observe(this, Observer(::updateUi))
    }

    private fun updateUi(model: EventsUiModel) {
        val context = this.context ?: return

        progress.visibility = if (model == Loading) VISIBLE else GONE

        when (model) {
            is Contect -> adapter.events = model.events
            is Navegation -> Toast.makeText(context, model.event.title, Toast.LENGTH_LONG).show()
        }
    }
}
