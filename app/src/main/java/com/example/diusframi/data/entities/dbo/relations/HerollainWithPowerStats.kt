package com.example.diusframi.data.entities.dbo.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.example.diusframi.data.entities.dbo.HerollainsDbo
import com.example.diusframi.data.entities.dbo.PowerStatsDbo

data class HerollainWithPowerStats(

    @Embedded val herollain: HerollainsDbo,
    @Relation(
        parentColumn = "id",
        entityColumn = "herollainId"
    )
    val powerStats: List<PowerStatsDbo>
)
