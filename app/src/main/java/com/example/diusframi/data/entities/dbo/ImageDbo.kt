package com.example.diusframi.data.entities.dbo

import androidx.annotation.Nullable
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "image")
data class ImageDbo(

    @PrimaryKey(autoGenerate = false) val id: Int,
    @Nullable val herollainId: Int?, //There could be a image withouth a herollain
    @Nullable val xs: String?,
    @Nullable val sm: String?,
    @Nullable val md: String?,
    @Nullable val lg: String?,
)
