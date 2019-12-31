package com.architect.coders.mu8.data.comics

import com.architect.coders.mu8.data.mapper.BaseResponseMapper
import com.architect.coders.mu8.data.utils.replaceHttps
import com.architect.codes.mu8.comics.Comic

class ComicsMapper : BaseResponseMapper<ComicResponse, Comic>() {

    override fun transform(input: ComicResponse): Comic {
        return Comic(
            id = input.id,
            title = input.title,
            thumbnailUrl = "${input.thumbnail.path}.${input.thumbnail.extension}".replaceHttps()
        )
    }
}