package com.architect.coders.mu8.data.database.converter

import androidx.room.TypeConverter
import com.architect.coders.mu8.data.response.common.ThumbnailEntity
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class ThumbnailTypeConverters {

    private val gson = Gson()

    @TypeConverter
    fun stringToThumbnail(data: String?): ThumbnailEntity {
        if (data == null) {
            return ThumbnailEntity()
        }
        val type = object : TypeToken<ThumbnailEntity>() {}.type
        return gson.fromJson(data, type)
    }

    @TypeConverter
    fun thumbnailToString(thumbnail: ThumbnailEntity?): String {
        if (thumbnail == null) {
            return gson.toJson(ThumbnailEntity())
        }
        return gson.toJson(thumbnail)
    }
}