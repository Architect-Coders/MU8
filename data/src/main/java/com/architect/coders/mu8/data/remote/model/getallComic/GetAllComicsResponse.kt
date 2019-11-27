package com.architect.coders.mu8.data.remote.model.getallComic

import com.google.gson.annotations.SerializedName

data class GetAllComicsResponse(
    @SerializedName("code")
    val code: Int,

    @SerializedName("status")
    val status: String,

    @SerializedName("data")
    val data : ComicsDataWrapperResponse
)