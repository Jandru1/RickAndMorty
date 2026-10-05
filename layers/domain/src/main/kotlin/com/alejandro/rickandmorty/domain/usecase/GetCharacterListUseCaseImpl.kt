package com.alejandro.rickandmorty.domain.usecase
import com.alejandro.rickandmorty.domain.model.CharacterListModel
import com.alejandro.rickandmorty.domain.model.CharacterModel
import com.alejandro.rickandmorty.domain.repository.RickAndMortyRepository

class GetCharacterListUseCaseImpl(
    private val repository: RickAndMortyRepository
): GetCharacterListUseCase {

    override suspend fun invoke(page: Int, name: String?): Result<CharacterListModel> {
        return repository.getCharacterList(page, name)
    }
}