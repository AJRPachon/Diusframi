package com.example.diusframi.data.entities.dbo

import androidx.annotation.Nullable
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "powerstats")
data class PowerStatsDbo(

    @PrimaryKey(autoGenerate = true) val id: Int,
    @Nullable val herollainId: Int?, //There could be a power stat withouth a herollain
    @Nullable val intelligence: Int?,
    @Nullable val strength: Int?,
    @Nullable val speed: Int?,
    @Nullable val durability: Int?,
    @Nullable val power: Int?,
    @Nullable val combat: Int?
)
