package com.architect.codes.mu8.events

interface EventsUseCase {
    suspend fun getEvents(): List<Event>
}

class EventsUserCaseImpl(private val eventsRepository: EventsRepository) : EventsUseCase {
    override suspend fun getEvents(): List<Event> = eventsRepository()
}
