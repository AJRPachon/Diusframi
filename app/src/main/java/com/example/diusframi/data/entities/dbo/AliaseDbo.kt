package com.example.diusframi.data.entities.dbo

import androidx.annotation.Nullable
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "aliase")
data class AliaseDbo(

    @PrimaryKey(autoGenerate = false) val id : Int,
    @Nullable val herollainId : Int?,
    @Nullable val name : String?,
)
