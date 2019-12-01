package com.architect.coders.mu8.data.characters

import com.architect.coders.mu8.data.mapper.BaseResponseMapper
import com.architect.coders.mu8.data.mapper.common.UrlsMapper
import com.architect.coders.mu8.data.utils.replaceHttps
import com.architect.codes.mu8.characters.Character

class CharactersMapper(private val urlsMapper: UrlsMapper) : BaseResponseMapper<CharactersResponse, Character>() {

    override fun transform(input: CharactersResponse): Character {
        return Character(
            input.id,
            input.name,
            input.description,
            "${input.thumbnail.path}.${input.thumbnail.extension}".replaceHttps(),
            urlsMapper.transform(input.urls)
        )
    }
}
