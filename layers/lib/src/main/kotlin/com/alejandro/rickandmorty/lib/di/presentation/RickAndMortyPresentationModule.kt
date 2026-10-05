package com.alejandro.rickandmorty.lib.di.presentation

import com.alejandro.rickandmorty.presentation.details.CharacterDetailsViewModel
import com.alejandro.rickandmorty.presentation.list.CharacterListViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val presentationModule = module {
    viewModel { CharacterListViewModel(get()) }
    viewModel { params -> CharacterDetailsViewModel(params.get(), get()) }
}