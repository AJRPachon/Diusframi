package com.example.diusframi.data.entities.dto


import com.google.gson.annotations.SerializedName

data class HerollainDto(

    @SerializedName("id") val id : Int?,
    @SerializedName("name") val name : String?,
    @SerializedName("powerstats") val powerStats : PowerStatsDto?,
    @SerializedName("appearance") val appearance : AppearanceDto?,
    @SerializedName("biography") val biography : BiographyDto?,
    @SerializedName("images") val images : ImageDto?,

)

data class HerollainListDto(

    //TODO Corregir esto cuando venga del servicio
    @SerializedName("id") val id : Int?,
)
