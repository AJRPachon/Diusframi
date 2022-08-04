package com.example.diusframi.data.entities.dbo.relations

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.example.diusframi.data.entities.dbo.AliaseDbo
import com.example.diusframi.data.entities.dbo.BiographyDbo


data class BiographyWithAliases(

    @Embedded
    val biographyDbo: BiographyDbo,

    @Relation(
        parentColumn = "id",
        entityColumn = "biographyId",
        associateBy = Junction(AliaseDbo::class, parentColumn = "id", entityColumn = "biographyId" )
    )
    val aliases : List<AliaseDbo>?
)