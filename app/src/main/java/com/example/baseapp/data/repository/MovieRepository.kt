package com.example.baseapp.data.repository

import com.example.baseapp.data.model.Movie
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext

class MovieRepository(
    private val movieApi: MovieApi,
    private val movieDb: MovieDao
) : Repository <List<Movie>> {

    override suspend fun getData(): List<Movie> {
        return withContext(Dispatchers.Default){
            movieApi.getMovies()
            delay(2000)
            listOf(Movie(1, "Movie 01"))
        }
    }
}