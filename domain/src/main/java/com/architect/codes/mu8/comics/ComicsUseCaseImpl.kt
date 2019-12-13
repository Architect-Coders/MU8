package com.architect.codes.mu8.comics

import com.architect.codes.mu8.callback.ComicRepository

class ComicsUseCaseImpl(private val comicRepository: ComicRepository) : ComicUseCase {
    override suspend fun invoke(): List<Comic> = comicRepository()
}