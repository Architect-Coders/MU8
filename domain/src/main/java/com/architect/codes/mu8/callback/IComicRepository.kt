package com.architect.codes.mu8.callback

import com.architect.codes.mu8.model.Comic

open interface IComicRepository {
    suspend fun getAllComics(): List<Comic>
}
