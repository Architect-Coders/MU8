package com.architect.codes.mu8.characters

import com.architect.codes.mu8.common.Urls

data class Character(
    val id: Long,
    val name: String,
    val description: String,
    val thumbnailUrl: String,
    val urls: List<Urls>
)