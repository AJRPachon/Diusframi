package com.example.diusframi.data.utils

import com.example.diusframi.data.entities.bo.*
import com.example.diusframi.data.entities.dbo.*
import com.example.diusframi.data.entities.dbo.relations.HerollainWithData
import com.example.diusframi.data.entities.dto.HerollainDto

//////////// DBO //////////////////////////////////////////////////////////////////////////////////

fun HerollainWithData.toBo() = HerollainBo(herollain.id, herollain.name, images.toBo(), powerStats.toBo(), appearances.toBo(), biography.toBo(), herollain.isFavorite)

fun ImageDbo.toBo() = ImageBo(xs, sm, md, lg)

fun PowerStatsDbo.toBo() = PowerStatBo(intelligence, strength, speed, durability, power, combat)

fun AppearanceDbo.toBo() = AppearanceBo(gender, race, emptyList(), emptyList(), eyeColor, hairColor)

fun BiographyDbo.toBo() = BiographyBo(fullName, alterEgos, emptyList(), placeOfBirth, firstAppearance, publisher, alignment)


//////////// DTO //////////////////////////////////////////////////////////////////////////////////

fun HerollainDto.toBo() = HerollainBo(id, name,
    ImageBo(images?.xs, images?.sm, images?.md, images?.lg),
    PowerStatBo(powerStats?.intelligence, powerStats?.strength, powerStats?.speed, powerStats?.durability, powerStats?.power, powerStats?.combat),
    AppearanceBo(appearance?.gender, appearance?.race, appearance?.height, appearance?.weight, appearance?.eyeColor, appearance?.hairColor),
    BiographyBo(biography?.fullName, biography?.alterEgos, biography?.aliases, biography?.placeOfBirth, biography?.firstAppearance, biography?.publisher, biography?.alignment),
    false
)
