package com.example.baseapp.di

import com.example.baseapp.data.repository.animes.AnimesApi
import com.example.baseapp.data.repository.animes.AnimesRepository
import com.example.baseapp.ui.home.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val mainModule = module {

    viewModel {
        HomeViewModel(
            repository = get()
        )
    }

    factory {
        AnimesRepository(get())
    }

    fun provideAnimeApi(retrofit: Retrofit): AnimesApi {
        return retrofit.create(AnimesApi::class.java)
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