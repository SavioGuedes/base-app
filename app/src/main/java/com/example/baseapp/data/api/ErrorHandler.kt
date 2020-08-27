package com.example.baseapp.data.api

import android.accounts.NetworkErrorException
import retrofit2.HttpException
import java.lang.Exception

class ErrorHandler {

    private val connectionError = "Parece que você perdeu a conexão, verifique e tente novamente."
    private val serviceError = "Hum... Algo deu errado."
    private val clientError = "Solicitação inválida, entre em contato com suporte."
    private val unknownError = "Um erro do sistema ou sua conexão podem estar impedindo a comunição, verifique e tente novamente."

    fun handleRequestError(error: Exception): ApiError {
        return when(error) {
            is HttpException -> handleApiError(error)
            is NetworkErrorException -> ApiError.ConnectionError(connectionError)
            else -> ApiError.UnknownError(unknownError)
        }
    }

    private fun handleApiError(error: HttpException): ApiError {
        return when(error.code()){
            in 400..499 -> ApiError.ClientError(clientError)
            else -> ApiError.ServiceError(serviceError)
        }
    }
}