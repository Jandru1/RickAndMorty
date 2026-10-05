package com.alejandro.rickandmorty.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.alejandro.rickandmorty.data.entity.local.CharacterLocalEntity
import com.alejandro.rickandmorty.data.entity.local.PageLocalEntity

@Dao
interface RickAndMortyDao {

    @Query("SELECT * FROM pages WHERE page = :page")
    suspend fun getPage(page: Int): PageLocalEntity?

    @Query("SELECT * FROM characters WHERE page = :page ORDER BY id ASC")
    suspend fun getCharactersByPage(page: Int): List<CharacterLocalEntity>

    @Query("SELECT * FROM characters WHERE id = :id")
    suspend fun getCharacter(id: Int): CharacterLocalEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCharacters(characters: List<CharacterLocalEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPage(page: PageLocalEntity)

}