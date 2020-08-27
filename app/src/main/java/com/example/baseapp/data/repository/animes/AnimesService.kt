package com.example.baseapp.data.repository.animes

import com.example.baseapp.data.model.Anime
import retrofit2.http.GET
import retrofit2.http.Query

interface AnimesService {

    @GET("anime")
    suspend fun getAnimes(
        @Query("sort")
        sort: String,
        @Query("page[limit]")
        pageLimit: Int
    ) : Anime
}