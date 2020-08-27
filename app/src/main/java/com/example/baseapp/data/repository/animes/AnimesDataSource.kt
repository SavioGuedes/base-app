package com.example.baseapp.data.repository.animes

import com.example.baseapp.data.api.ApiResult
import com.example.baseapp.data.api.ErrorHandler
import com.example.baseapp.data.model.Anime

class AnimesDataSource(
    private val animesApi: AnimesService,
    private val errorHandler: ErrorHandler
) {
    suspend fun fetchAnimes(sort: String, pageLimit: Int): ApiResult<Anime> {
        return try {
            val animesRequest = animesApi.getAnimes(sort, pageLimit)
            ApiResult.Success(animesRequest)
        } catch (error: Exception) {
            ApiResult.Error(errorHandler.handleRequestError(error))
        }
    }
}