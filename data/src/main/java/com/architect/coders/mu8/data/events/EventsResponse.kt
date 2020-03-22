package com.architect.coders.mu8.data.events

import com.architect.coders.mu8.data.response.common.ThumbnailResponse
import com.architect.coders.mu8.data.utils.replaceHttps
import com.architect.codes.mu8.utils.EMPTY_STRING

data class EventsResponse(
    val id: Long = 0L,
    val title: String = EMPTY_STRING,
    val description: String = EMPTY_STRING,
    val thumbnail: ThumbnailResponse = ThumbnailResponse()
)

fun EventsResponse.toDatabaseEntity() = EventsEntity(
    id = id,
    title = title,
    description = description,
    thumbnail = "${thumbnail.path}.${thumbnail.extension}".replaceHttps()
)
