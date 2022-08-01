package com.example.diusframi.data.entities.dbo.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.example.diusframi.data.entities.dbo.AppearanceDbo
import com.example.diusframi.data.entities.dbo.HerollainDbo

data class HerolainWithAppearance(

    @Embedded val herollain: HerollainDbo,
    @Relation(
        parentColumn = "id",
        entityColumn = "herollainId"
    )
    val appearances: List<AppearanceDbo>
)
