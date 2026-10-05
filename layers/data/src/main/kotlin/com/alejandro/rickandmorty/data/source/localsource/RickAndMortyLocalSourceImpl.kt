package com.alejandro.rickandmorty.data.source.localsource

import com.alejandro.rickandmorty.data.database.RickAndMortyDao
import com.alejandro.rickandmorty.data.entity.local.PageLocalEntity
import com.alejandro.rickandmorty.data.source.localsource.mapper.RickAndMortyLocalMapper
import com.alejandro.rickandmorty.domain.model.CharacterListModel
import com.alejandro.rickandmorty.domain.model.CharacterModel

class RickAndMortyLocalSourceImpl(
    private val dao: RickAndMortyDao,
    private val mapper: RickAndMortyLocalMapper
): RickAndMortyLocalSource {

    override suspend fun getCharacterList(page: Int): CharacterListModel? {
        val pageEntity = dao.getPage(page) ?: return null
        return CharacterListModel(
            characters = dao.getCharactersByPage(page).map { mapper.toModel(it) },
            hasNextPage = pageEntity.hasNextPage
        )
    }

    override suspend fun setCharacterList(
        page: Int,
        characters: CharacterListModel
    ) {
        dao.insertCharacters(
            characters = characters.characters.map { mapper.toLocal(it, page) }
        )
        dao.insertPage(
            page = PageLocalEntity(page = page, hasNextPage = characters.hasNextPage),
        )
    }

    override suspend fun getCharacterDetails(id: Int): CharacterModel? {
        return dao.getCharacter(id)?.let { mapper.toModel(it) }
    }
}