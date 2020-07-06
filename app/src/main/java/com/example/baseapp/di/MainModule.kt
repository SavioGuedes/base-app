package com.example.baseapp.di

import com.example.baseapp.ui.main.MainRepository
import com.example.baseapp.ui.main.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val mainModule = module {
    factory {
        MainRepository()
    }

    viewModel {
        MainViewModel(
            repository = get()
        )
    }
}