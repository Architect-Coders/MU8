package com.architect.coders.mu8.data.remote.model.getallComic

import com.google.gson.annotations.SerializedName

data class ComicsDataWrapperResponse (
    @SerializedName("results")
    val results : List<ComicResponse>
)
