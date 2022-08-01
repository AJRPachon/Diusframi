package com.example.diusframi.data.entities.dbo

import androidx.annotation.Nullable
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "herollains")
data class HerollainsDbo(

    @PrimaryKey(autoGenerate = true) val id: Int,
    @Nullable val name: String,
    @Nullable val powerstats: String,
    @Nullable val isFavorite: Boolean
)
