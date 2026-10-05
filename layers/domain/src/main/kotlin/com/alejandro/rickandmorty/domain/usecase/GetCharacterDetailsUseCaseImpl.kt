package com.alejandro.rickandmorty.domain.usecase

import com.alejandro.rickandmorty.domain.model.CharacterListModel
import com.alejandro.rickandmorty.domain.model.CharacterModel
import com.alejandro.rickandmorty.domain.repository.RickAndMortyRepository

class GetCharacterDetailsUseCaseImpl(
    val repository: RickAndMortyRepository
) : GetCharacterDetailsUseCase{

    override suspend fun invoke(id: Int): Result<CharacterModel> =
        repository.getCharacterDetails(id)
}