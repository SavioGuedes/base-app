package com.example.baseapp.data.api

sealed class ApiResult<out T : Any> {

    data class  Success<out T : Any>(val data: T): ApiResult<T>()
    data class  Error(val error: ApiError): ApiResult<Nothing>()
}