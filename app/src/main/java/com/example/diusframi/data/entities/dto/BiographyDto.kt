package com.example.diusframi.data.entities.dto

import com.google.gson.annotations.SerializedName

data class BiographyDto(

    @SerializedName("fullName") val fullName : String?,
    @SerializedName("alterEgos") val alterEgos : String?,
    @SerializedName("aliases") val aliases : List<String>?,
    @SerializedName("placeOfBirth") val placeOfBirth : String?,
    @SerializedName("firstAppearance") val firstAppearance : String?,
    @SerializedName("publisher") val publisher : String?,
    @SerializedName("alignment") val alignment : String?
)
