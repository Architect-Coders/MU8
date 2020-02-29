package com.architect.coders.mu8.data.response.common

import com.architect.codes.mu8.common.Urls

data class UrlsResponse(val type: String, val url: String)

fun UrlsResponse.toDomainModel() = Urls(type, url)
