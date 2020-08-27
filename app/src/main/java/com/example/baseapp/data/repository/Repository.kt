package com.example.baseapp.data.repository

import com.example.baseapp.data.api.ApiResult

interface Repository<out T : Any> {
    suspend fun getData() : ApiResult<T>
}