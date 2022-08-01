package com.example.diusframi.data.utils

import com.example.diusframi.data.entities.bo.*
import com.example.diusframi.data.entities.dbo.*
import com.example.diusframi.data.entities.dbo.relations.HerollainWithData


//TODO Corregir esto
fun HerollainDbo.toBo() = HerollainBo(id,name, ImageBo("","","",""),
    PowerStatBo(0,0,0,0,0,0) ,
    AppearanceBo("","", emptyList(), emptyList(), "", ""),
    BiographyBo("","", emptyList(), "", "","",""),
    false)

fun HerollainWithData.toBo() = HerollainBo(herollain.id, herollain.name, images.toBo(), powerStats.toBo(), appearances.toBo(), biography.toBo(), herollain.isFavorite)

fun ImageDbo.toBo() = ImageBo(xs, sm, md, lg)

fun PowerStatsDbo.toBo() = PowerStatBo(intelligence, strength, speed, durability, power, combat)

fun AppearanceDbo.toBo() = AppearanceBo(gender, race, emptyList(), emptyList(), eyeColor, hairColor)

fun BiographyDbo.toBo() = BiographyBo(fullName, alterEgos, emptyList(), placeOfBirth, firstAppearance, publisher, alignment)