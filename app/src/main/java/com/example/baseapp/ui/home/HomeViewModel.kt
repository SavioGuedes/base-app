package com.example.baseapp.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.baseapp.data.api.ApiResult
import com.example.baseapp.data.model.Anime
import com.example.baseapp.data.repository.animes.AnimesRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class HomeViewModel(private val animesRepository: AnimesRepository) : ViewModel() {

    private val animesLiveData: MutableLiveData<Anime> by lazy {
        MutableLiveData<Anime>().also {
            loadAnimes()
        }
    }

    val erroLiveData: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

    private fun loadAnimes(){
        CoroutineScope(Dispatchers.Main).launch{
            val result = withContext(Dispatchers.Default) {
                animesRepository.getData()
            }

            when(result){
                is ApiResult.Success -> {
                    animesLiveData.value = result.data
                }
                is ApiResult.Error -> {
                    erroLiveData.value = result.error.errorMessage
                }
            }
        }
    }

    fun getAnimes(): LiveData<Anime> {
        return animesLiveData
    }
}
