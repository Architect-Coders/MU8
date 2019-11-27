package com.architect.coders.mu8.data.remote.model.getallComic

import com.google.gson.annotations.SerializedName

data class ComicResponse(
    @SerializedName("id")
    val id: Int,

    @SerializedName("title")
    val title: String,

    @SerializedName("description")
    val description: String,

    @SerializedName("format")
    val format: String,

    @SerializedName("thumbnail")
    val thumbnail: ThumbnailResponse,

    @SerializedName("characters")
    val charactersWrapper : CharactersWrapperResponse
)