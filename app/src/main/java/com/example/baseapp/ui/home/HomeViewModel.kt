package com.example.baseapp.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.baseapp.data.model.Anime
import com.example.baseapp.data.repository.animes.AnimesRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class HomeViewModel(private val repository: AnimesRepository) : ViewModel() {

    private val animesLiveData: MutableLiveData<Anime> by lazy {
        MutableLiveData<Anime>().also {
            loadAnimes()
        }
    }

    private fun loadAnimes(){
        CoroutineScope(Dispatchers.Main).launch{
            val animes = withContext(Dispatchers.Default) {
                repository.getData()
            }
            animesLiveData.value = animes
        }
    }

    fun getAnimes(): LiveData<Anime> {
        return animesLiveData
    }
}
