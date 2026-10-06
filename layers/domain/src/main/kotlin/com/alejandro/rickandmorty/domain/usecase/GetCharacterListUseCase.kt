package com.alejandro.rickandmorty.domain.usecase

import com.alejandro.rickandmorty.domain.model.CharacterListModel

interface GetCharacterListUseCase {

    suspend operator fun invoke(page: Int, name: String?): Result<CharacterListModel>
}