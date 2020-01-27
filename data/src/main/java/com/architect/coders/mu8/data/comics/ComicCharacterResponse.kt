package com.architect.coders.mu8.data.comics

import com.architect.coders.mu8.data.response.common.MarvelItemResponse
import com.architect.codes.mu8.utils.EMPTY_STRING

data class ComicCharacterResponse(
    val available: Int = 0,
    val collectionURI: String = EMPTY_STRING,
    val items: List<MarvelItemResponse> = emptyList()
)
