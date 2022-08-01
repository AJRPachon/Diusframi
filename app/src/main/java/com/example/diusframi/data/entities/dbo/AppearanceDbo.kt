package com.example.diusframi.data.entities.dbo

import androidx.annotation.Nullable
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "appearance")
data class AppearanceDbo(

    @PrimaryKey(autoGenerate = true) val id: Int,
    @Nullable val herollainId: Int?, //There could be an appearance withouth a herollain
    @Nullable val gender: String?,
    @Nullable val race: String?,
    @Nullable val height: String?,
    @Nullable val weight: String?,
    @Nullable val eyeColor: String?,
    @Nullable val hairColor: String?
)
