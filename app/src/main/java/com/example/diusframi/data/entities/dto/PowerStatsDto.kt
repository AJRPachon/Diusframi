package com.example.diusframi.data.entities.dto

import com.google.gson.annotations.SerializedName

data class PowerStatsDto(

    @SerializedName("intelligence") val intelligence : Int?,
    @SerializedName("strength") val strength : Int?,
    @SerializedName("speed") val speed : String?,
    @SerializedName("durability") val durability : Int?,
    @SerializedName("power") val power : Int?,
    @SerializedName("combat") val combat : Int?
)
