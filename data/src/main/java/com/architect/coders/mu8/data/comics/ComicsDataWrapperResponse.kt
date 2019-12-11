package com.architect.coders.mu8.data.comics

import com.architect.coders.mu8.data.comics.ComicResponse
import com.google.gson.annotations.SerializedName

data class ComicsDataWrapperResponse (
    @SerializedName("results") val results : List<ComicResponse>
)
