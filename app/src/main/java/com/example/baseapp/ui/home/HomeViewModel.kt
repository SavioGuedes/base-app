package com.example.baseapp.ui.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.baseapp.data.model.Anime
import com.example.baseapp.data.repository.animes.AnimesRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class HomeViewModel(private val repository: AnimesRepository) : ViewModel() {

    val animesLiveData = MutableLiveData<Anime>()

    fun getAnimes(){
        CoroutineScope(Dispatchers.Main).launch{
            val animes = withContext(Dispatchers.Default) {
                repository.getData()
            }

            animesLiveData.value = animes
        }
    }
}
