package com.architect.coders.mu8.data.characters

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.architect.coders.mu8.data.response.common.ThumbnailEntity
import com.architect.coders.mu8.data.response.common.UrlsEntity
import com.architect.codes.mu8.utils.EMPTY_STRING

@Entity
data class CharactersEntity(
    @PrimaryKey(autoGenerate = false) val id: Long = 0L,
    val name: String = EMPTY_STRING,
    val description: String = EMPTY_STRING,
    val thumbnail: ThumbnailEntity,
    val urls: List<UrlsEntity>
)