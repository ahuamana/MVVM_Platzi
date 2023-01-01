package com.platzi.android.rickandmorty.parcelable

import android.os.Parcelable
import com.platzi.android.rickandmorty.domain.Character
import com.platzi.android.rickandmorty.domain.Location
import com.platzi.android.rickandmorty.domain.Origin
import kotlinx.android.parcel.Parcelize

@Parcelize
data class CharacterParcelable(
    val id: Int,
    val name: String,
    val image: String?,
    val gender: String,
    val species: String,
    val status:String,
    val origin: OriginParcelable,
    val location: LocationParcelable,
    val episodeList: List<String>
):Parcelable

@Parcelize
data class OriginParcelable(
    val name: String,
    val url: String
) : Parcelable

@Parcelize
data class LocationParcelable(
    val name: String,
    val url: String
) : Parcelable

fun Character.toCharacterParcelable() = CharacterParcelable(
    id = id,
    name = name,
    image = image,
    gender = gender,
    species = species,
    status = status,
    origin = origin.toOriginParcelable(),
    location = location.toLocationParcelable(),
    episodeList = episodeList
)

fun Origin.toOriginParcelable() = OriginParcelable(
    name = name,
    url = url
)

fun Location.toLocationParcelable() = LocationParcelable(
    name = name,
    url = url
)


fun CharacterParcelable.toCharacterDomain() = Character(
    id = id,
    name = name,
    image = image,
    gender = gender,
    species = species,
    status = status,
    origin = origin.toOriginDomain(),
    location = location.toLocationDomain(),
    episodeList = episodeList
)

fun OriginParcelable.toOriginDomain() = Origin(
    name = name,
    url = url
)

fun LocationParcelable.toLocationDomain() = Location(
    name = name,
    url = url
)