package com.architect.coders.mu8.data.remote.repository

import com.architect.coders.mu8.data.MARVEL_PUBLIC_KEY
import com.architect.coders.mu8.data.createHashCode
import com.architect.coders.mu8.data.remote.RetrofitManager

class ComicRepository :
    IComicRepository {
    private val retrofitManager = RetrofitManager()

    override suspend fun getAllComics(timeStamp: String) =
        retrofitManager.getService()
            .getAllComics(
                timeStamp = timeStamp,
                apiKey = MARVEL_PUBLIC_KEY,
                hash = createHashCode()
            )
}
