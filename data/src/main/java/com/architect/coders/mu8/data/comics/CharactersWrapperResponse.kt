package com.architect.coders.mu8.data.comics

import com.google.gson.annotations.SerializedName

data class CharactersWrapperResponse(
    @SerializedName("items")
    val characterList: List<ComicCharacterResponse>
)
