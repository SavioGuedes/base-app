package com.example.baseapp.data.repository

interface Repository<T> {
    suspend fun getData() : T
}