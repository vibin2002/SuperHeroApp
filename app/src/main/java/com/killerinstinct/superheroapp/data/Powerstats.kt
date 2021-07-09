package com.killerinstinct.superheroapp.data


import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Powerstats(
    val combat: Int?,
    val durability: Int?,
    val intelligence: Int?,
    val power: Int?,
    val speed: Int?,
    val strength: Int?
): Serializable