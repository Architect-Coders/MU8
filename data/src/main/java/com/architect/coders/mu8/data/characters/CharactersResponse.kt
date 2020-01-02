package com.architect.coders.mu8.data.characters

import com.architect.coders.mu8.data.response.common.ThumbnailResponse
import com.architect.coders.mu8.data.response.common.UrlsResponse
import com.architect.codes.mu8.EMPTY_STRING

data class CharactersResponse(
    val id: Long = 0L,
    val name: String = EMPTY_STRING,
    val description: String = EMPTY_STRING,
    val thumbnail: ThumbnailResponse,
    val urls: List<UrlsResponse>
)
