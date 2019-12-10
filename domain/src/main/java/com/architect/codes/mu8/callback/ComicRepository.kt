package com.architect.codes.mu8.callback

import com.architect.codes.mu8.model.Comic

open interface ComicRepository {
    suspend fun getAllComics(): List<Comic>
}
