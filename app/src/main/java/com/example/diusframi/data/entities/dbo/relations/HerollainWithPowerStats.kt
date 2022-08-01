package com.example.diusframi.data.entities.dbo.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.example.diusframi.data.entities.dbo.HerollainDbo
import com.example.diusframi.data.entities.dbo.PowerStatsDbo

data class HerollainWithPowerStats(

    @Embedded val herollain: HerollainDbo,
    @Relation(
        parentColumn = "id",
        entityColumn = "herollainId"
    )
    val powerStats: List<PowerStatsDbo>
)
