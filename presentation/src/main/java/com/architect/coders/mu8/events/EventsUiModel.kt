package com.architect.coders.mu8.events

import com.architect.codes.mu8.events.Event

sealed class EventsUiModel {
    object Loading : EventsUiModel()
    class Contect(val events: List<Event>) : EventsUiModel()
    class Navegation(val event: Event) : EventsUiModel()
}
