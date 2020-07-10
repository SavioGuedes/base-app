package com.example.baseapp.data.repository.animes

import com.example.baseapp.data.model.Anime
import com.example.baseapp.data.repository.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class AnimesRepository(
    private val animesApi: AnimesApi
) : Repository<Anime> {

    override suspend fun getData(): Anime {
        return withContext(Dispatchers.Default){
            animesApi.getAnimes("popularityRank", 20)
        }
    }
}