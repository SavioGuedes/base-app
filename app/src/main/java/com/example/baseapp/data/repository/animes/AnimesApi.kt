package com.example.baseapp.data.repository.animes

import com.example.baseapp.data.model.Anime
import retrofit2.Call
import retrofit2.http.GET

interface AnimesApi {

    @GET("trending/anime")
    suspend fun getAnimes() : Anime
}