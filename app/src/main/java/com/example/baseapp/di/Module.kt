package com.example.baseapp.di

import com.example.baseapp.data.repository.AnimeApi
import com.example.baseapp.data.repository.AnimeRepository
import com.example.baseapp.ui.main.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val mainModule = module {

    viewModel {
        HomeViewModel(
            repository = get()
            //TODO: add navigation as injection
        )
    }

    factory {
        AnimeRepository(get())
    }

    fun provideAnimeApi(retrofit: Retrofit): AnimeApi {
        return retrofit.create(AnimeApi::class.java)
    }

    factory {
        provideAnimeApi(get())
    }

    factory {
        Retrofit.Builder()
            .baseUrl("https://kitsu.io/api/edge/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}