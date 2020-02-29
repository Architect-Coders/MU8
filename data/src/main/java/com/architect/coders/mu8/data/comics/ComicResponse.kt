package com.architect.coders.mu8.data.comics

import com.architect.coders.mu8.data.response.common.ThumbnailResponse
import com.architect.coders.mu8.data.response.common.UrlsResponse
import com.architect.coders.mu8.data.utils.replaceHttps
import com.architect.codes.mu8.utils.CHARACTERS_REGEX
import com.architect.codes.mu8.utils.EMPTY_STRING
import com.google.gson.annotations.SerializedName

data class ComicResponse(
    @SerializedName("id")
    val id: Long = 0L,

    @SerializedName("title")
    val title: String = EMPTY_STRING,

    @SerializedName("description")
    val description: String? = EMPTY_STRING,

    @SerializedName("format")
    val format: String = EMPTY_STRING,

    @SerializedName("urls")
    val urls: List<UrlsResponse> = emptyList(),

    @SerializedName("thumbnail")
    val thumbnail: ThumbnailResponse = ThumbnailResponse(),

    @SerializedName("characters")
    val characters: ComicCharacterResponse = ComicCharacterResponse()
)

fun ComicResponse.toDatabaseEntity() = ComicsEntity(
    id = id,
    title = title,
    description = description ?: EMPTY_STRING,
    format = format,
    urls = urls,
    thumbnailUrl = "${thumbnail.path}.${thumbnail.extension}".replaceHttps(),
    charactersId = characters.items.filter { character ->
        character.resourceURI.contains(CHARACTERS_REGEX)
    }.map { characterITem ->
        characterITem.resourceURI.substringAfter(CHARACTERS_REGEX)
    }
)
