package com.architect.codes.mu8.events

interface EventsRepository {
    suspend operator fun invoke(): List<Event>
}
