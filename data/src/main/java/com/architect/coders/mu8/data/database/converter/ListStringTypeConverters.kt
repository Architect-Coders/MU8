package com.architect.coders.mu8.data.database.converter

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class ListStringTypeConverters {

    private val gson = Gson()

    @TypeConverter
    fun stringToListOfStrings(data: String?): List<String> {
        if (data == null || data == "null") {
            return emptyList()
        }
        val type = object : TypeToken<List<String>>() {}.type
        return gson.fromJson(data, type)
    }

    @TypeConverter
    fun listOfStringsToString(urls: List<String>?): String {
        if (urls.isNullOrEmpty()) {
            gson.toJson(emptyList<String>())
        }
        return gson.toJson(urls)
    }
}