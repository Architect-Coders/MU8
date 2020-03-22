package com.architect.coders.mu8.data.events

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface EventsDAO {

    @Query("SELECT * FROM EventsEntity")
    fun getAllEvents(): List<EventsEntity>

    @Query("SELECT COUNT(*) FROM EventsEntity")
    fun eventsCounts(): Int

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertEvents(data: List<EventsEntity>)
}