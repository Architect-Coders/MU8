package com.architect.codes.mu8.comics

import com.architect.codes.mu8.common.Urls

data class Comic(
    val id: Long,
    val title: String,
    val description: String,
    val thumbnailUrl: String,
    val urls: List<Urls> = emptyList(),
    val charactersId: List<String> = emptyList()
)
