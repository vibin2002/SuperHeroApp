package com.killerinstinct.superheroapp.data


import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Appearance(
    val eyeColor: String?,
    val gender: String?,
    val hairColor: String?,
    val height: List<String>?,
    val race: String?,
    val weight: List<String>?
): Serializable