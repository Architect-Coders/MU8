package com.architect.coders.mu8.events

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.architect.coders.mu8.events.EventsViewModel.EventsUiModel.Content
import com.architect.coders.mu8.events.EventsViewModel.EventsUiModel.Loading
import com.architect.coders.mu8.events.EventsViewModel.EventsUiModel.Navigation
import com.architect.coders.mu8.utils.ScopedViewModel
import com.architect.codes.mu8.events.Event
import com.architect.codes.mu8.events.EventsUseCase
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.launch

class EventsViewModel(private val eventsUseCase: EventsUseCase, uiDispatcher: CoroutineDispatcher) : ScopedViewModel(uiDispatcher) {

    sealed class EventsUiModel {
        object Loading : EventsUiModel()
        data class Content(val events: List<Event>) : EventsUiModel()
        data class Navigation(val event: Event) : EventsUiModel()
    }

    private val _model = MutableLiveData<EventsUiModel>()
    val model: LiveData<EventsUiModel>
        get() {
            if (_model.value == null) getEvents()
            return _model
        }

    private fun getEvents() {
        launch {
            _model.value = Loading
            _model.value = Content(eventsUseCase())
        }
    }

    fun onEventClick(event: Event) {
        _model.value = Navigation(event)
    }
}
