package com.architect.codes.mu8.interactor.comics

import com.architect.codes.mu8.model.Comic

interface IComicUseCase {
    suspend fun getComics() : List<Comic>
}