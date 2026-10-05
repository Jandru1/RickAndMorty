package com.alejandro.rickandmorty.domain.usecase

import com.alejandro.rickandmorty.domain.model.CharacterModel

interface GetCharacterDetailsUseCase {

    suspend operator fun invoke(id: Int): Result<CharacterModel>
}