package com.alejandro.rickandmorty.data.entity.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import org.intellij.lang.annotations.PrintFormat

@Entity(tableName = "pages")
data class PageLocalEntity(
    @PrimaryKey val page: Int,
    val hasNextPage: Boolean
)