package com.architect.coders.mu8.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.architect.coders.mu8.data.characters.CharactersDAO
import com.architect.coders.mu8.data.characters.CharactersEntity
import com.architect.coders.mu8.data.comics.ComicsDAO
import com.architect.coders.mu8.data.comics.ComicsEntity
import com.architect.coders.mu8.data.database.converter.ListStringTypeConverters
import com.architect.coders.mu8.data.database.converter.ThumbnailTypeConverters
import com.architect.coders.mu8.data.database.converter.UrlsTypeConverters
import com.architect.coders.mu8.data.events.EventsDAO
import com.architect.coders.mu8.data.events.EventsEntity

private const val DATABASE_VERSION = 2

@Database(
    entities = [
        CharactersEntity::class,
        ComicsEntity::class,
        EventsEntity::class],
    version = DATABASE_VERSION)
@TypeConverters(
    UrlsTypeConverters::class,
    ThumbnailTypeConverters::class,
    ListStringTypeConverters::class
)
abstract class MU8Database : RoomDatabase() {
    abstract fun getCharactersDao(): CharactersDAO
    abstract fun getEventsDao(): EventsDAO
    abstract fun getComicsDao(): ComicsDAO
}