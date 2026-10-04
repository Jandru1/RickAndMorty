package com.alejandro.rickandmorty.lib.di.domain

import com.alejandro.rickandmorty.domain.usecase.GetCharacterListUseCase
import com.alejandro.rickandmorty.domain.usecase.GetCharacterListUseCaseImpl
import org.koin.dsl.module
import retrofit2.Retrofit

val domainModule = module {

    factory<GetCharacterListUseCase> { GetCharacterListUseCaseImpl(get()) }
}