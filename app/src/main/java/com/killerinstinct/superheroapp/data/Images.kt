package com.killerinstinct.superheroapp.data


import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Images(
    val lg: String?,
    val md: String?,
    val sm: String?,
    val xs: String?
): Serializable