package com.architect.coders.mu8.data.database.converter

import androidx.room.TypeConverter
import com.architect.coders.mu8.data.response.common.UrlsEntity
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class UrlsTypeConverters {

    private val gson = Gson()

    @TypeConverter
    fun stringToUrls(data: String?): List<UrlsEntity> {
        if (data == null) {
            return emptyList()
        }
        val type = object : TypeToken<List<UrlsEntity>>() {}.type
        return gson.fromJson(data, type)
    }

    @TypeConverter
    fun urlsToString(urls: List<UrlsEntity>?): String {
        if (urls.isNullOrEmpty()) {
            gson.toJson(emptyList<UrlsEntity>())
        }
        return gson.toJson(urls)
    }
}