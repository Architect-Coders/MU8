package com.architect.codes.mu8.interactor.comics

import com.architect.codes.mu8.callback.IComicRepository
import com.architect.codes.mu8.model.Comic

class ComicsUseCase(private val comicRepository: IComicRepository) : IComicUseCase {
    override suspend fun getComics(): List<Comic> {
        return comicRepository.getAllComics()
    }
}