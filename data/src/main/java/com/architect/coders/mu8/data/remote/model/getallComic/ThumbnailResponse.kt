package com.architect.coders.mu8.data.remote.model.getallComic

import com.google.gson.annotations.SerializedName

data class ThumbnailResponse (
    @SerializedName("path")
    val path: String,

   @SerializedName("extension")
   val extension: String
)
