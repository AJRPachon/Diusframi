package com.example.diusframi.data.entities.dbo

import androidx.annotation.Nullable
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "biography")
data class BiographyDbo(

    @PrimaryKey(autoGenerate = true) val id: Int,
    @Nullable val herollainId: Int, //There could be a biography withouth a herollain
    @Nullable val fullName: String,
    @Nullable val alterEgos: String,
    @Nullable val aliases: List<String>,
    @Nullable val placeOfBirth: String,
    @Nullable val firstAppearance: String,
    @Nullable val publisher: String,
    @Nullable val alignment: String
)
