package com.example.baseapp.data.repository

import com.example.baseapp.data.model.Anime
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class AnimeRepository(
    private val animeApi: AnimeApi
) : Repository <Anime> {

    override suspend fun getData(): Anime {
        return withContext(Dispatchers.Default){
            animeApi.getAnimes()
        }
    }
}