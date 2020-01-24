package com.architect.codes.mu8.events

import com.architect.codes.mu8.utils.EMPTY_STRING

data class Event(
    val id: Long = 0L,
    val title: String = EMPTY_STRING,
    val thumbnail: String = EMPTY_STRING
)
