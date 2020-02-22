package com.architect.coders.mu8.data.events

import com.architect.coders.mu8.data.DataApp
import com.architect.coders.mu8.data.service.MarvelServiceManager
import com.architect.coders.mu8.data.utils.DEFAULT_OFFSET
import com.architect.coders.mu8.data.utils.LIMIT
import com.architect.coders.mu8.data.utils.MARVEL_PUBLIC_KEY
import com.architect.coders.mu8.data.utils.TIME_STAMP
import com.architect.codes.mu8.events.Event
import com.architect.codes.mu8.events.EventsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class EventsRepositoryImpl(application: DataApp) : EventsRepository {

    private val database = application.database

    override suspend fun invoke(): List<Event> = withContext(Dispatchers.IO) {

        with(database.getEventsDao()) {

            if (eventsCounts() <= 0) {
                val response = MarvelServiceManager.service.getAllEvents(
                    TIME_STAMP, MARVEL_PUBLIC_KEY,
                    MarvelServiceManager.hashcode,
                    DEFAULT_OFFSET,
                    LIMIT
                )

                response.body()?.let {
                    it.data.results.map { eventResponse -> eventResponse.toDatabaseEntity() }
                        .also { events -> insertEvents(events) }
                }
            }

            return@withContext getAllEvents().map { it.toDomainModel() }
        }
    }
}

