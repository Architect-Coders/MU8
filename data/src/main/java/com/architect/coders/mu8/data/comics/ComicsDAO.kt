package com.architect.coders.mu8.data.comics

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.IGNORE
import androidx.room.Query

@Dao
interface ComicsDAO {
    @Query("SELECT * FROM comics_table")
    fun getAllComics(): List<ComicsEntity>

    @Query(value = "SELECT COUNT(id) FROM comics_table")
    fun comicsCount(): Int

    @Insert(onConflict = IGNORE)
    fun insertComics(comics: List<ComicsEntity>)

    @Query("SELECT characters_id FROM comics_table WHERE id = :comicId")
    fun getComicCharacters(comicId: Long): List<String>
}