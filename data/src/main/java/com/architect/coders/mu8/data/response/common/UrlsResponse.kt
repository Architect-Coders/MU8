package com.architect.coders.mu8.data.response.common

import com.architect.codes.mu8.common.Urls

data class UrlsResponse(val type: String, val url: String)

fun UrlsResponse.toDomainEntity() = Urls(type, url)
