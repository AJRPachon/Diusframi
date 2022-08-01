package com.example.diusframi.data.entities.dbo.relations

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.example.diusframi.data.entities.dbo.*

data class HerollainWithData (

    @Embedded
    val herollain: HerollainDbo,

    @Relation(
        parentColumn = "id",
        entityColumn = "herollainId",
        associateBy = Junction(AppearanceDbo::class, parentColumn = "id", entityColumn = "herollainId" )
    )
    val appearances: AppearanceDbo,

    @Relation(
        parentColumn = "id",
        entityColumn = "herollainId",
        associateBy = Junction(BiographyDbo::class, parentColumn = "id", entityColumn = "herollainId" )
    )
    val biography: BiographyDbo,

    @Relation(
        parentColumn = "id",
        entityColumn = "herollainId",
        associateBy = Junction(PowerStatsDbo::class, parentColumn = "id", entityColumn = "herollainId" )
    )
    val powerStats: PowerStatsDbo,

    @Relation(
        parentColumn = "id",
        entityColumn = "herollainId",
        associateBy = Junction(ImageDbo::class, parentColumn = "id", entityColumn = "herollainId" )
    )
    val images: ImageDbo


)