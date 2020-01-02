package com.architect.coders.mu8.events

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.architect.coders.mu8.utils.ScopedViewModel
import com.architect.codes.mu8.events.EventsUseCase
import kotlinx.coroutines.launch

class EventsViewModel(private val eventsUseCase: EventsUseCase) : ScopedViewModel() {

    private val _model = MutableLiveData<EventsUiModel>()
    val model: LiveData<EventsUiModel>
    get() { if (_model.value == null) getEvents()
    return _model }

    private fun getEvents() {
        launch {
            _model.value = EventsUiModel.Loading
            _model.value = EventsUiModel.Contect(eventsUseCase.getEvents())
        }
    }
}
