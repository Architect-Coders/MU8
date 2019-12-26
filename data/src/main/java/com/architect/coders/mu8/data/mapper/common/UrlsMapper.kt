package com.architect.coders.mu8.data.mapper.common

import com.architect.coders.mu8.data.mapper.BaseResponseMapper
import com.architect.coders.mu8.data.response.common.UrlsEntity
import com.architect.codes.mu8.common.Urls

class UrlsMapper : BaseResponseMapper<UrlsEntity, Urls>() {

    override fun transform(input: UrlsEntity): Urls {
        return Urls(input.type, input.url)
    }

    fun transform(input: List<UrlsEntity>): List<Urls> {
        val output = mutableListOf<Urls>()
        input.forEach { output.add(transform(it)) }
        return output
    }
}