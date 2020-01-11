package com.architect.coders.mu8.data.characters

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.architect.coders.mu8.data.response.common.UrlsResponse
import com.architect.coders.mu8.data.response.common.toDomainEntity
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

fun CharactersEntity.toDomainEntity() = Character(id, name, description, thumbnailUrl, urls.map { it.toDomainEntity() }, comicIds)