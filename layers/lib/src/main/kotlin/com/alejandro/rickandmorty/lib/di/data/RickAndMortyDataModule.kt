package com.alejandro.rickandmorty.lib.di.data

import com.alejandro.rickandmorty.data.api.RickAndMortyApi
import com.alejandro.rickandmorty.domain.repository.RickAndMortyRepository
import com.alejandro.rickandmorty.data.repository.RickAndMortyRepositoryImpl
import com.alejandro.rickandmorty.data.source.remotesource.RickAndMortyRemoteSource
import com.alejandro.rickandmorty.data.source.remotesource.RickAndMortyRemoteSourceImpl
import com.alejandro.rickandmorty.data.source.remotesource.mapper.RickAndMortyRemoteMapper
import com.alejandro.rickandmorty.data.source.remotesource.mapper.RickAndMortyRemoteMapperImpl
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

val dataModule = module {

    single<Retrofit> {
        Retrofit.Builder()
            .baseUrl("https://rickandmortyapi.com/api/")
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
    }

    single<RickAndMortyApi> { get<Retrofit>().create(RickAndMortyApi::class.java) }
    single<RickAndMortyRepository> { RickAndMortyRepositoryImpl(get()) }
    single<RickAndMortyRemoteMapper> { RickAndMortyRemoteMapperImpl() }
    single<RickAndMortyRemoteSource> { RickAndMortyRemoteSourceImpl(get(), get()) }
}