package com.architect.codes.mu8.interactor.comics

import com.architect.codes.mu8.callback.ComicRepository
import com.architect.codes.mu8.model.Comic

class ComicsUseCaseImpl(private val comicRepository: ComicRepository) : ComicUseCase {
    override suspend fun getComics(): List<Comic> {
        return comicRepository.getAllComics()
    }
}