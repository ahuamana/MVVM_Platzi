package com.platzi.android.rickandmorty.data

import com.platzi.android.rickandmorty.domain.Episode
import io.reactivex.Flowable
import io.reactivex.Maybe
import io.reactivex.Single

interface RemoteCharacterDataSource {
    fun getAllCharacters(page: Int): Single<List<com.platzi.android.rickandmorty.domain.Character>>
}

interface LocalCharacterDataSource{
    fun getAllFavoriteCharacters(): Flowable<List<com.platzi.android.rickandmorty.domain.Character>>
    fun getFavoriteCharacter(characterId: Int): Maybe<Boolean>
    fun updateFavoriteCharacter(character: com.platzi.android.rickandmorty.domain.Character): Maybe<Boolean>
}

interface RemoteEpisodeDataSource {
    fun getEpisodeFromCharacter(episodeUrl: List<String>): Single<List<Episode>>
}