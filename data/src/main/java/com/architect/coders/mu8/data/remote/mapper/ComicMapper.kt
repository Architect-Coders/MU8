package com.architect.coders.mu8.data.remote.mapper

import com.architect.coders.mu8.data.remote.model.getallComic.ComicResponse
import com.architect.codes.mu8.model.Comic

class ComicMapper {
    fun transform(comicR: ComicResponse): Comic =
        Comic(
            id = comicR.id,
            title = comicR.title,
            description = comicR.description,
            thumbnailUrl = comicR.thumbnail.path + "." + comicR.thumbnail.extension,
            characters = comicR.charactersWrapper.characterList.map { charR -> charR.name }
        )
}