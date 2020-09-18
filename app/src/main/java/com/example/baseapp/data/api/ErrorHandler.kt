package com.example.baseapp.data.api

import android.accounts.NetworkErrorException
import android.content.Context
import com.example.baseapp.R
import retrofit2.HttpException
import java.lang.Exception

class ErrorHandler(
    private val context: Context
) {

    fun handleRequestError(error: Exception): ApiError {
        return when(error) {
            is HttpException -> handleApiError(error)
            is NetworkErrorException -> ApiError.ConnectionError(context.getString(R.string.connection_error))
            else -> ApiError.UnknownError(context.getString(R.string.unknown_error))
        }
    }

    private fun handleApiError(error: HttpException): ApiError {
        return when(error.code()){
            in 400..499 -> ApiError.ClientError(context.getString(R.string.client_error))
            else -> ApiError.ServiceError(context.getString(R.string.service_error))
        }
    }
}