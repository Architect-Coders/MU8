package com.architect.coders.mu8.data.remote.mapper

import com.architect.coders.mu8.data.remote.model.getallComic.ComicResponse
import com.architect.codes.mu8.model.Comic

class ComicMapper {
    fun transform(comicR: ComicResponse): Comic {
        return Comic(
            id = comicR.id,
            title = comicR.title?: "",
            thumbnailUrl = comicR.thumbnail.path + "." + comicR.thumbnail.extension
        )
    }
}