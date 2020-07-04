package com.example.baseapp.ui.main

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext

class MainRepository {

    suspend fun getMovies() : List<Movie>{
        return withContext(Dispatchers.Default){
            delay(3000)
            listOf(
                Movie(1, "Movie 01"),
                Movie(2, "Movie 02")
            )
        }
    }
}