package com.architect.coders.mu8.data.events

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.architect.codes.mu8.events.Event
import com.architect.codes.mu8.utils.EMPTY_LONG
import com.architect.codes.mu8.utils.EMPTY_STRING

@Entity
data class EventsEntity(
    @PrimaryKey(autoGenerate = false)
    val id: Long = EMPTY_LONG,
    val title: String = EMPTY_STRING,
    val description: String = EMPTY_STRING,
    val thumbnail: String = EMPTY_STRING
)

fun EventsEntity.toDomainModel() = Event(
    id = id,
    title = title,
    description = description,
    thumbnail = thumbnail
)