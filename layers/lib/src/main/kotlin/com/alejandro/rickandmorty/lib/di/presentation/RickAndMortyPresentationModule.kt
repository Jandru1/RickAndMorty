package com.alejandro.rickandmorty.lib.di.presentation

import com.alejandro.rickandmorty.presentation.CharacterListViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val presentationModule = module {
    viewModel { CharacterListViewModel(get()) }
}