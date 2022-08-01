package com.example.diusframi.data.utils

import com.example.diusframi.data.entities.bo.*
import com.example.diusframi.data.entities.dbo.*
import com.example.diusframi.data.entities.dbo.relations.HerollainWithData
import com.example.diusframi.data.entities.dto.HerollainDto

//////////// DBO.toBO //////////////////////////////////////////////////////////////////////////////////

fun HerollainWithData.toBo() = HerollainBo(herollain.id, herollain.name, images.toBo(), powerStats.toBo(), appearances.toBo(), biography.toBo(), herollain.isFavorite)

fun ImageDbo.toBo() = ImageBo(xs, sm, md, lg)

fun PowerStatsDbo.toBo() = PowerStatBo(intelligence, strength, speed, durability, power, combat)

fun AppearanceDbo.toBo() = AppearanceBo(gender, race, height, weight, eyeColor, hairColor)

fun BiographyDbo.toBo() = BiographyBo(fullName, alterEgos, emptyList(), placeOfBirth, firstAppearance, publisher, alignment)


//////////// DTO.toBO //////////////////////////////////////////////////////////////////////////////////

fun HerollainDto.toBo() = HerollainBo(id, name,
    ImageBo(images?.xs, images?.sm, images?.md, images?.lg),
    PowerStatBo(powerStats?.intelligence, powerStats?.strength, powerStats?.speed, powerStats?.durability, powerStats?.power, powerStats?.combat),
    AppearanceBo(appearance?.gender, appearance?.race, appearance?.height?.get(1), appearance?.weight?.get(1), appearance?.eyeColor, appearance?.hairColor),
    BiographyBo(biography?.fullName, biography?.alterEgos, biography?.aliases, biography?.placeOfBirth, biography?.firstAppearance, biography?.publisher, biography?.alignment),
    false
)

//////////// BO.toDBO //////////////////////////////////////////////////////////////////////////////////

fun HerollainBo.toDbo() = HerollainDbo(id, name, isFavorite)

fun PowerStatBo.toDbo(herollainId : Int) = PowerStatsDbo(0, herollainId, intelligence, strength, speed, durability, power, combat )

fun AppearanceBo.toDbo(herollainId: Int) = AppearanceDbo(0, herollainId = herollainId, gender, race, height, weight, eyeColor, hairColor)

fun BiographyBo.toDbo(herollainId: Int) = BiographyDbo(0, herollainId = herollainId, fullName, alterEgos, placeOfBirth, firstAppearance, publisher, alignment)

fun ImageBo.toDbo(herollainId: Int) = ImageDbo(0, herollainId = herollainId, xs, sm, md, lg)

