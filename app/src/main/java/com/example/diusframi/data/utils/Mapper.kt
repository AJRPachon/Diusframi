package com.example.diusframi.data.utils

import com.example.diusframi.data.entities.bo.*
import com.example.diusframi.data.entities.dbo.*
import com.example.diusframi.data.entities.dbo.relations.BiographyWithAliases
import com.example.diusframi.data.entities.dbo.relations.HerollainWithData
import com.example.diusframi.data.entities.dto.HerollainDto

//////////// DBO.toBO //////////////////////////////////////////////////////////////////////////////////

//fun HerollainWithData.toBo() = HerollainBo(herollain?.id, herollain?.name, images?.toBo(), powerStats?.toBo(), appearances?.toBo(), biography?.biographyDbo?.toBo() , herollain?.isFavorite)
//
//fun ImageDbo.toBo() = ImageBo(xs, sm, md, lg)
//
//fun PowerStatsDbo.toBo() = PowerStatBo(intelligence, strength, speed, durability, power, combat)
//
//fun AppearanceDbo.toBo() = AppearanceBo(gender, race, height, weight, eyeColor, hairColor)
//
//fun BiographyDbo.toBo() = BiographyBo(id, fullName, alterEgos, emptyList() ,placeOfBirth, firstAppearance, publisher, alignment)

fun HerollainWithData.toBo() = HerollainBo(herollain?.id, herollain?.name, images?.toBo(), powerStats?.toBo(), appearances?.toBo(), biography?.toBo() , herollain?.isFavorite)

fun ImageDbo.toBo() = ImageBo(xs, sm, md, lg)

fun PowerStatsDbo.toBo() = PowerStatBo(intelligence, strength, speed, durability, power, combat)

fun AppearanceDbo.toBo() = AppearanceBo(gender, race, height, weight, eyeColor, hairColor)

fun BiographyDbo.toBo() = BiographyBo(id, fullName, alterEgos, emptyList(), placeOfBirth, firstAppearance, publisher, alignment)


//////////// DTO.toBO //////////////////////////////////////////////////////////////////////////////////

fun HerollainDto.toBo() = HerollainBo(id, name,
    ImageBo(images?.xs, images?.sm, images?.md, images?.lg),
    PowerStatBo(powerStats?.intelligence, powerStats?.strength, powerStats?.speed, powerStats?.durability, powerStats?.power, powerStats?.combat),
    AppearanceBo(appearance?.gender, appearance?.race, appearance?.height?.get(1), appearance?.weight?.get(1), appearance?.eyeColor, appearance?.hairColor),
    BiographyBo(-1, biography?.fullName, biography?.alterEgos, aliases = biography?.aliases ,biography?.placeOfBirth, biography?.firstAppearance, biography?.publisher, biography?.alignment),
    false
)



//fun HerollainDto.toBo() = HerollainBo(id, name,
//    ImageBo(images?.xs, images?.sm, images?.md, images?.lg),
//    PowerStatBo(powerStats?.intelligence, powerStats?.strength, powerStats?.speed, powerStats?.durability, powerStats?.power, powerStats?.combat),
//    AppearanceBo(appearance?.gender, appearance?.race, appearance?.height?.get(1), appearance?.weight?.get(1), appearance?.eyeColor, appearance?.hairColor),
//    BiographyBo(-1, biography?.fullName, biography?.alterEgos, aliases = biography?.aliases ,biography?.placeOfBirth, biography?.firstAppearance, biography?.publisher, biography?.alignment),
//    false
//)


//////////// BO.toDBO //////////////////////////////////////////////////////////////////////////////////

//fun HerollainBo.toDbo() = HerollainWithData(
//    HerollainDbo(id, name, isFavorite),
//    AppearanceDbo(0, id, appearances?.gender, appearances?.race, appearances?.height, appearances?.weight, appearances?.eyeColor, appearances?.hairColor ),
//    BiographyWithAliases(BiographyDbo(0, id, biography?.fullName, biography?.alterEgos, biography?.placeOfBirth, biography?.firstAppearance, biography?.publisher, biography?.alignment), biography?.aliases?.map { AliaseDbo(0, id, name) }),
//    PowerStatsDbo(0, id, powerstats?.intelligence, powerstats?.strength,powerstats?.speed, powerstats?.durability, powerstats?.power, powerstats?.combat),
//    ImageDbo(0, id, images?.xs, images?.sm, images?.md, images?.lg)
//)

fun HerollainBo.toDbo() = HerollainWithData(
    HerollainDbo(id, name, isFavorite),
    AppearanceDbo(0, id, appearances?.gender, appearances?.race, appearances?.height, appearances?.weight, appearances?.eyeColor, appearances?.hairColor ),
    BiographyDbo(0, id, biography?.fullName, biography?.alterEgos, biography?.placeOfBirth, biography?.firstAppearance, biography?.publisher, biography?.alignment),
    PowerStatsDbo(0, id, powerstats?.intelligence, powerstats?.strength,powerstats?.speed, powerstats?.durability, powerstats?.power, powerstats?.combat),
    ImageDbo(0, id, images?.xs, images?.sm, images?.md, images?.lg)
)

fun HerollainBo.toDBO() = HerollainDbo(id, name, isFavorite)

fun PowerStatBo.toDbo(herollainId : Int) = PowerStatsDbo(id = herollainId, herollainId, intelligence, strength, speed, durability, power, combat )

fun AppearanceBo.toDbo(herollainId: Int) = AppearanceDbo(id = herollainId, herollainId = herollainId, gender, race, height, weight, eyeColor, hairColor)

fun BiographyBo.toDbo(herollainId: Int) = BiographyDbo(id = herollainId, herollainId = herollainId, fullName, alterEgos, placeOfBirth, firstAppearance, publisher, alignment)

fun ImageBo.toDbo(herollainId: Int) = ImageDbo(id = herollainId, herollainId = herollainId, xs, sm, md, lg)

fun AliaseBo.toDbo(herollainId: Int) = AliaseDbo(id = herollainId, herollainId, name)

