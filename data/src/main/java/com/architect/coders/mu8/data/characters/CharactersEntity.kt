package com.architect.coders.mu8.data.characters

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.architect.coders.mu8.data.response.common.UrlsResponse
import com.architect.coders.mu8.data.response.common.toDomainModel
import com.architect.codes.mu8.characters.Character
import com.architect.codes.mu8.utils.EMPTY_STRING

@Entity
data class CharactersEntity(
    @PrimaryKey(autoGenerate = false) val id: Long = 0L,
    val name: String = EMPTY_STRING,
    val description: String = EMPTY_STRING,
    val thumbnailUrl: String = EMPTY_STRING,
    val urls: List<UrlsResponse> = emptyList(),
    val comicIds: List<String> = emptyList()
)

fun CharactersEntity.toDomainModel() = Character(
    id = id,
    name = name,
    description = description,
    thumbnailUrl = thumbnailUrl,
    urls = urls.map { it.toDomainModel() },
    comicIds = comicIds
)