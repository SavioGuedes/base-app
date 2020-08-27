package com.example.baseapp.data.repository.animes

import com.example.baseapp.data.api.ApiResult
import com.example.baseapp.data.model.Anime
import com.example.baseapp.data.repository.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class AnimesRepository(
    private val animesDataSource: AnimesDataSource
) : Repository<Anime> {

    override suspend fun getData(): ApiResult<Anime> {
        return withContext(Dispatchers.Default){
            animesDataSource.fetchAnimes("popularityRank", 20)
        }
    }
}