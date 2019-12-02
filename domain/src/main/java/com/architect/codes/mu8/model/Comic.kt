package com.architect.codes.mu8.model

data class Comic(
    val id: Int,
    val title: String,
    val description: String,
    val thumbnailUrl: String,
    val characters: List<String>
)
