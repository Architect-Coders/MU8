package com.architect.codes.mu8.callback

import com.architect.codes.mu8.comics.Comic

interface ComicRepository {
    suspend operator fun invoke(): List<Comic>
}
