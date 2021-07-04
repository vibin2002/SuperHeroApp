package com.killerinstinct.superheroapp.data


import com.google.gson.annotations.SerializedName

data class Appearance(
    val eyeColor: String?,
    val gender: String?,
    val hairColor: String?,
    val height: List<String>?,
    val race: String?,
    val weight: List<String>?
)