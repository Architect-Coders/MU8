package com.architect.coders.mu8.data.remote.mapper

import com.architect.coders.mu8.data.remote.model.getallComic.ComicResponse
import com.architect.coders.mu8.data.replaceHttps
import com.architect.codes.mu8.DOT_STRING
import com.architect.codes.mu8.EMPTY_STRING
import com.architect.codes.mu8.model.Comic

class ComicMapper {
    fun transform(comicR: ComicResponse): Comic {
        return Comic(
            id = comicR.id,
            title = comicR.title ?: EMPTY_STRING,
            thumbnailUrl = "${comicR.thumbnail.path}.${comicR.thumbnail.extension}".replaceHttps().replaceHttps()
        )
    }
}