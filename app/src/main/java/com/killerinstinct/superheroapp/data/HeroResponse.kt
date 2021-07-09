package com.killerinstinct.superheroapp.data


import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class HeroResponse(
    val appearance: Appearance?,
    val biography: Biography?,
    val connections: Connections?,
    val id: Int?,
    val images: Images?,
    val name: String?,
    val powerstats: Powerstats?,
    val slug: String?,
    val work: Work?
): Serializable