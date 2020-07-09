package com.example.baseapp.data.repository

import com.example.baseapp.data.model.Anime
import retrofit2.Call
import retrofit2.http.GET

interface AnimeApi {

    @GET("trending/anime")
    suspend fun getAnimes() : Anime
}