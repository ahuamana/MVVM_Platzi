package com.platzi.android.rickandmorty.api

import com.platzi.android.rickandmorty.database.CharacterEntity
import com.platzi.android.rickandmorty.database.LocationEntity
import com.platzi.android.rickandmorty.database.OriginEntity
import com.platzi.android.rickandmorty.domain.Location
import com.platzi.android.rickandmorty.domain.Origin

fun CharacterResponseServer.toCharacterDomainList(): List<com.platzi.android.rickandmorty.domain.Character> = results.map {
    it.run{
        com.platzi.android.rickandmorty.domain.Character(
            id,
            name,
            image,
            gender,
            species,
            status,
            origin.toOriginDomain(),
            location.toLocationDomain(),
            episodeList.map { episode -> "$episode/" }
        )
    }
}

fun OriginServer.toOriginDomain() = Origin(
    name,
    url
)

fun LocationServer.toLocationDomain() = Location(
    name,
    url
)

fun EpisodeServer.toEpisodeDomain() = com.platzi.android.rickandmorty.domain.Episode(
    id,
    name
)
