package com.example.baseapp.data.repository

import com.example.baseapp.data.model.Movie

interface MainRepository {
    suspend fun getMovies() : List<Movie>
}