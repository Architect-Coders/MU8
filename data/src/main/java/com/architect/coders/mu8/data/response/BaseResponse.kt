package com.architect.coders.mu8.data.response

data class BaseResponse<T>(val code: Int, val status: String, val data: DataResponse<T>)

data class DataResponse<T>(
    val offset: Int,
    val limit: Int,
    val total: Int,
    val count: Int,
    val results: List<T>
)