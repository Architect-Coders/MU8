package com.architect.codes.mu8.comics

import com.architect.codes.mu8.utils.EMPTY_STRING

data class Comic(
    val id: Int,
    val title: String = EMPTY_STRING,
    val thumbnailUrl: String = EMPTY_STRING
)
