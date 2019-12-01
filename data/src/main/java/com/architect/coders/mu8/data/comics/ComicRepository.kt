package com.architect.coders.mu8.data.comics

import com.architect.coders.mu8.data.service.MarvelServiceManager
import com.architect.coders.mu8.data.utils.MARVEL_PUBLIC_KEY
import com.architect.coders.mu8.data.utils.createHashCode

class ComicRepository : IComicRepository {

    override suspend fun getAllComics(timeStamp: String) =
        MarvelServiceManager.service
            .getAllComics(
                timeStamp = timeStamp,
                apiKey = MARVEL_PUBLIC_KEY,
                hash = createHashCode()
            )
}