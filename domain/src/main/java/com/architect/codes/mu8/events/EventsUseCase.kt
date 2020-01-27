package com.architect.codes.mu8.events

interface EventsUseCase {
    suspend operator fun invoke(): List<Event>
}

class EventsUserCaseImpl(private val eventsRepository: EventsRepository) : EventsUseCase {
    override suspend operator fun invoke(): List<Event> = eventsRepository()
}
