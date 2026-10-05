package com.alejandro.rickandmorty.domain.usecase

import com.alejandro.rickandmorty.domain.model.CharacterListModel
import com.alejandro.rickandmorty.domain.model.CharacterModel

interface GetCharacterListUseCase {

    suspend operator fun invoke(page: Int, name: String?): Result<CharacterListModel>
}