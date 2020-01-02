package com.architect.coders.mu8.data.events

import com.architect.coders.mu8.data.mapper.BaseResponseMapper
import com.architect.coders.mu8.data.utils.replaceHttps
import com.architect.codes.mu8.events.Event

class EventsMapper : BaseResponseMapper<EventsResponse, Event> () {
    override fun transform(input: EventsResponse): Event {
        return Event(
            id = input.id,
            title = input.title,
            thumbnail = "${input.thumbnail.path}.${input.thumbnail.extension}".replaceHttps()
        )
    }
}
