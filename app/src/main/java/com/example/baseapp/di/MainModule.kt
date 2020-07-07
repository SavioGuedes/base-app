package com.example.baseapp.di

import com.example.baseapp.data.repository.MainApiDataSource
import com.example.baseapp.ui.main.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val mainModule = module {
    factory {
        MainApiDataSource()
    }

    viewModel {
        MainViewModel(
            repository = get()
            //TODO: add navigation as injection
        )
    }
}