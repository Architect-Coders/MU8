package com.architect.coders.mu8.data.database.converter

import androidx.room.TypeConverter
import com.architect.coders.mu8.data.response.common.UrlsResponse
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class UrlsTypeConverters {

    private val gson = Gson()

    @TypeConverter
    fun stringToUrls(data: String?): List<UrlsResponse> {
        if (data == null) {
            return emptyList()
        }
        val type = object : TypeToken<List<UrlsResponse>>() {}.type
        return gson.fromJson(data, type)
    }

    @TypeConverter
    fun urlsToString(urls: List<UrlsResponse>?): String {
        if (urls.isNullOrEmpty()) {
            gson.toJson(emptyList<UrlsResponse>())
        }
        return gson.toJson(urls)
    }
}