package com.alejandro.rickandmorty.lib.di

import com.alejandro.rickandmorty.lib.di.data.dataModule
import com.alejandro.rickandmorty.lib.di.domain.domainModule
import com.alejandro.rickandmorty.lib.di.presentation.presentationModule
import org.koin.dsl.module

val appModules = listOf(
    presentationModule,
    domainModule,
    dataModule
)