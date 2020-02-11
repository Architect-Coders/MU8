package com.architect.coders.mu8.data.comics

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.architect.coders.mu8.data.response.common.UrlsResponse
import com.architect.coders.mu8.data.response.common.toDomainModel
import com.architect.codes.mu8.comics.Comic
import com.architect.codes.mu8.utils.EMPTY_STRING

@Entity(tableName = "comics_table")
data class ComicsEntity(
    @PrimaryKey(autoGenerate = false) val id: Long = 0L,
    val title: String = EMPTY_STRING,
    val description: String = EMPTY_STRING,
    val format: String = EMPTY_STRING,
    val urls: List<UrlsResponse> = emptyList(),
    @ColumnInfo(name = "thumbnail_url") val thumbnailUrl: String = EMPTY_STRING,
    @ColumnInfo(name = "characters_id") val charactersId: List<String> = emptyList()
)

fun ComicsEntity.toDomainModel() = Comic(
    id = id,
    title = title,
    description = description,
    thumbnailUrl = thumbnailUrl,
    urls = urls.map { it.toDomainModel() },
    charactersId = charactersId
)
