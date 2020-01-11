package com.architect.coders.mu8.data.events

import com.architect.coders.mu8.data.service.MarvelServiceManager
import com.architect.coders.mu8.data.utils.MARVEL_PUBLIC_KEY
import com.architect.coders.mu8.data.utils.TIME_STAMP
import com.architect.codes.mu8.events.Event
import com.architect.codes.mu8.events.EventsRepository

class EventsRepositoryImpl(private val mapper: EventsMapper) : EventsRepository {

    override suspend fun invoke(): List<Event> {
        val response = MarvelServiceManager.service.getAllEvents(
            TIME_STAMP, MARVEL_PUBLIC_KEY,
            MarvelServiceManager.hashcode
        )

        val events = mutableListOf<Event>()
        if (response.isSuccessful) {
            response.body()?.data?.results?.forEach {
                events.add(mapper.transform(it))
            }
        }

        return events
    }
}
