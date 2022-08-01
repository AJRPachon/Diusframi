package com.example.diusframi.data.entities.dto


import com.google.gson.annotations.SerializedName

data class HerollainDto(

    @SerializedName("id") val id : Int?,
    @SerializedName("name") val name : String?,
    @SerializedName("slug") val slug : String?,
    @SerializedName("powerStats") val powerStats : List<PowerStatsDto>?,
    @SerializedName("appearance") val appearance : List<AppearanceDto>?,
    @SerializedName("biography") val biography : List<BiographyDto>?,
    @SerializedName("images") val images : List<ImageDto>?,

)

data class HerollainListDto(

    //TODO Corregir esto cuando venga del servicio
    @SerializedName("id") val id : Int?,
)
