package com.alejandro.rickandmorty.domain.usecase
import com.alejandro.rickandmorty.domain.model.CharacterModel
import com.alejandro.rickandmorty.domain.repository.RickAndMortyRepository
import com.alejandro.rickandmorty.domain.usecase.getCharacterUseCase

class getCharacterListUseCaseImpl(
    open val repository: RickAndMortyRepository
): getCharacterUseCase {

    suspend fun invoke(page: Int): List<CharacterModel> {
        return repository.getCharacterList()
    }
}