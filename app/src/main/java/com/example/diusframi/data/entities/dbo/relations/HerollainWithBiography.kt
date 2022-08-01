package com.example.diusframi.data.entities.dbo.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.example.diusframi.data.entities.dbo.BiographyDbo
import com.example.diusframi.data.entities.dbo.HerollainDbo

data class HerollainWithBiography(

    @Embedded val herollain: HerollainDbo,
    @Relation(
        parentColumn = "id",
        entityColumn = "herollainId",
    )
    val biographies: List<BiographyDbo>
)
