package com.example.baseapp.di

import com.example.baseapp.data.api.ErrorHandler
import com.example.baseapp.data.repository.animes.AnimesDataSource
import com.example.baseapp.data.repository.animes.AnimesService
import com.example.baseapp.data.repository.animes.AnimesRepository
import com.example.baseapp.ui.home.HomeViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val mainModule = module {

    viewModel {
        HomeViewModel(get())
    }

    factory {
        AnimesRepository(get())
    }

    factory {
        AnimesDataSource(get(), ErrorHandler(androidContext()))
    }

    fun provideAnimeApi(retrofit: Retrofit): AnimesService {
        return retrofit.create(AnimesService::class.java)
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