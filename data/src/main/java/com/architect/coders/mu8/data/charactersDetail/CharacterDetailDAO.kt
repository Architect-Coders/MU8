package com.architect.coders.mu8.data.charactersDetail

import androidx.room.Dao
import androidx.room.Query
import com.architect.codes.mu8.characters.Character

@Dao
interface CharacterDetailDAO {

    @Query(value = "SELECT * FROM CharactersEntity WHERE id = id")
    fun findbyId(id: Long): Character

}