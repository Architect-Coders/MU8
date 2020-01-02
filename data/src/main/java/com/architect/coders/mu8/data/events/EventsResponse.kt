package com.architect.coders.mu8.data.events

import com.architect.coders.mu8.data.response.common.ThumbnailResponse
import com.architect.codes.mu8.EMPTY_STRING

data class EventsResponse(
    val id: Long = 0L,
    val title: String = EMPTY_STRING,
    val description: String = EMPTY_STRING,
    val thumbnail: ThumbnailResponse
)
