package com.architect.coders.mu8.data.remote.model.getallComic

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class CharacterResponse (
    @SerializedName("resourceURI")
    val resourceURI: String,

    @SerializedName("name")
    val name: String
) : Parcelable
