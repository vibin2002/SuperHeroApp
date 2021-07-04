package com.killerinstinct.superheroapp.data

import retrofit2.Response
import retrofit2.http.GET

interface HeroApi{

    @GET("all.json")
    suspend fun getSuperHeroes(): Response<List<HeroResponse>>

}