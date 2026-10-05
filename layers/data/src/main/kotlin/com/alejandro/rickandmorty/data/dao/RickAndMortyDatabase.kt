package com.alejandro.rickandmorty.data.dao

import androidx.room.Database
import androidx.room.RoomDatabase
import com.alejandro.rickandmorty.data.entity.local.CharacterLocalEntity
import com.alejandro.rickandmorty.data.entity.local.PageLocalEntity

@Database(
    entities = [CharacterLocalEntity::class, PageLocalEntity::class],
    version = 1,
    exportSchema = false
)
abstract class RickAndMortyDatabase : RoomDatabase() {
    abstract fun dao(): RickAndMortyDao
}