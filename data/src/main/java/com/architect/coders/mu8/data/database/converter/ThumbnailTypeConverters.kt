package com.architect.coders.mu8.data.database.converter

import androidx.room.TypeConverter
import com.architect.coders.mu8.data.response.common.ThumbnailResponse
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class ThumbnailTypeConverters {

    private val gson = Gson()

    @TypeConverter
    fun stringToThumbnail(data: String?): ThumbnailResponse {
        if (data == null) {
            return ThumbnailResponse()
        }
        val type = object : TypeToken<ThumbnailResponse>() {}.type
        return gson.fromJson(data, type)
    }

    @TypeConverter
    fun thumbnailToString(thumbnail: ThumbnailResponse?): String {
        if (thumbnail == null) {
            return gson.toJson(ThumbnailResponse())
        }
        return gson.toJson(thumbnail)
    }
}