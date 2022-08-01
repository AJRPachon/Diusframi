package com.example.diusframi.data.entities.bo

data class HerollainBo (

    val id : Int,
    val name: String?,
    val urls: ImageBo?,
    val powerstats: PowerStatBo?,
    val appearances: AppearanceBo?,
    val biography: BiographyBo?,
    val isFavorite: Boolean?
)
