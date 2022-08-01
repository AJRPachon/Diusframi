package com.example.diusframi.data.entities.dto

import com.google.gson.annotations.SerializedName

data class ImageDto(

    @SerializedName("xs") val xs : String?,
    @SerializedName("sm") val sm : String?,
    @SerializedName("md") val md : String?,
    @SerializedName("lg") val lg : String?
)
