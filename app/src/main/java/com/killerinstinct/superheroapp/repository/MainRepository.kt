package com.killerinstinct.superheroapp.repository

import android.util.Log
import com.killerinstinct.superheroapp.utils.Resource
import com.killerinstinct.superheroapp.data.HeroApi
import com.killerinstinct.superheroapp.data.HeroResponse
import javax.inject.Inject

class MainRepository @Inject constructor(
    private val api: HeroApi
) {
    suspend fun getHeroesData(): Resource<List<HeroResponse>> {
        return try {
            val response = api.getSuperHeroes()
            val result = response.body()
            if(response.isSuccessful && result != null) {
                Log.d("NetworkReq",result.toString())
                Resource.Success(result)
            } else {
                Log.d("NetworkReq",response.message().toString())
                Resource.Error(response.message())
            }
        } catch(e: Exception) {
            Resource.Error(e.message ?: "An error occurred")
        }
    }
}