package com.example.baseapp.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.baseapp.data.model.Movie
import com.example.baseapp.data.repository.MainApiDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainViewModel(private val repository: MainApiDataSource) : ViewModel() {

    val moviesLiveData = MutableLiveData<List<Movie>>()

    fun getMovies(){
        CoroutineScope(Dispatchers.Main).launch{
            val movies = withContext(Dispatchers.Default) {
                repository.getMovies()
            }
            moviesLiveData.value = movies
        }
    }
}
