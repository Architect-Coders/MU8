package com.architect.coders.mu8.data.characters

import com.architect.coders.mu8.data.response.common.ThumbnailResponse
import com.architect.coders.mu8.data.response.common.UrlsResponse
import com.architect.coders.mu8.data.utils.replaceHttps
import com.architect.codes.mu8.utils.COMICS_REGEX
import com.architect.codes.mu8.utils.EMPTY_STRING

data class CharactersResponse(
    val id: Long = 0L,
    val name: String = EMPTY_STRING,
    val description: String = EMPTY_STRING,
    val thumbnail: ThumbnailResponse = ThumbnailResponse(),
    val urls: List<UrlsResponse> = emptyList(),
    val comics: CharactersComicsResponse = CharactersComicsResponse()
)

fun CharactersResponse.toDatabaseEntity() = CharactersEntity(
    id = id,
    name = name,
    description = description,
    thumbnailUrl = "${thumbnail.path}.${thumbnail.extension}".replaceHttps(),
    urls = urls,
    comicIds = comics.items.filter { comic ->
        comic.resourceURI.contains(COMICS_REGEX)
    }.map { comics ->
        comics.resourceURI.substringAfter(delimiter = COMICS_REGEX)
    }
)