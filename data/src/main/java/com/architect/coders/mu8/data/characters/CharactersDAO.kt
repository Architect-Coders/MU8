package com.architect.coders.mu8.data.characters

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.IGNORE
import androidx.room.Query

@Dao
interface CharactersDAO {

    @Query(value = "SELECT * FROM CharactersEntity")
    fun getAllCharacters(): List<CharactersEntity>

    @Query(value = "SELECT COUNT(id) FROM CharactersEntity")
    fun charactersCount(): Int

    @Insert(onConflict = IGNORE)
    fun insertCharacters(characters: List<CharactersEntity>)

    @Query(value = "SELECT * FROM CharactersEntity WHERE id = :id")
    fun findbyId(id: Long): CharactersEntity

    @Insert(onConflict = IGNORE)
    fun insertCharacter(character: CharactersEntity)
}