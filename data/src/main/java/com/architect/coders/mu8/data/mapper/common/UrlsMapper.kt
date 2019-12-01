package com.architect.coders.mu8.data.mapper.common

import com.architect.coders.mu8.data.mapper.BaseResponseMapper
import com.architect.coders.mu8.data.response.common.UrlsResponse
import com.architect.codes.mu8.model.Urls

class UrlsMapper : BaseResponseMapper<UrlsResponse, Urls>() {

    override fun transform(input: UrlsResponse): Urls {
        return Urls(input.type, input.url)
    }

    fun transform(input: List<UrlsResponse>): List<Urls> {
        val output = mutableListOf<Urls>()
        input.forEach { output.add(transform(it)) }
        return output
    }
}