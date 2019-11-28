package com.architect.coders.mu8.data.remote.model.getallComic

import com.google.gson.annotations.SerializedName

data class CharactersWrapperResponse (
    @SerializedName("items")
    val characterList : List<CharacterResponse>
)
