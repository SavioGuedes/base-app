package com.example.baseapp.data.api

sealed class ApiError(val errorMessage: String) {
    data class ConnectionError(val message: String): ApiError(message)
    data class ClientError(val message: String): ApiError(message)
    data class ServiceError(val message: String): ApiError(message)
    data class UnknownError(val message: String): ApiError(message)
}