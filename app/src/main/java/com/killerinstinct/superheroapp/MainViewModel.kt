package com.killerinstinct.superheroapp

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.killerinstinct.superheroapp.data.HeroResponse
import com.killerinstinct.superheroapp.di.MainRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: MainRepository
): ViewModel() {

    val _herolist = MutableLiveData<List<HeroResponse>>()

    init {
        fetchData()
    }

    private fun fetchData(){
        viewModelScope.launch {
            when(val heroResponse = repository.getHeroesData())
            {
                is Resource.Error -> _herolist.value = mutableListOf()
                is Resource.Success -> {
                    _herolist.value = heroResponse.data!!
                    Log.d("WandaVision",_herolist.value.toString())
                }
            }
        }
    }

}