package com.killerinstinct.superheroapp.data


import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Connections(
    val groupAffiliation: String?,
    val relatives: String?
): Serializable