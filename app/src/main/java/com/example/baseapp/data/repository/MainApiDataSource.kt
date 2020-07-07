package com.example.baseapp.data.repository

import com.example.baseapp.data.model.Movie
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext

class MainApiDataSource : MainRepository {

    override suspend fun getMovies(): List<Movie> {
        return withContext(Dispatchers.Default){
            delay(2000)
            listOf(Movie(1, "Movie 01"))
        }
    }
}