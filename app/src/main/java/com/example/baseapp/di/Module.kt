package com.example.baseapp.di

import com.example.baseapp.data.repository.MovieApi
import com.example.baseapp.data.repository.MovieDao
import com.example.baseapp.data.repository.MovieRepository
import com.example.baseapp.ui.main.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val mainModule = module {
    factory {
        MovieRepository(get(), get())
    }

    factory {
        MovieApi()
    }

    factory {
        MovieDao()
    }

    viewModel {
        MainViewModel(
            repository = get()
            //TODO: add navigation as injection
        )
    }
}