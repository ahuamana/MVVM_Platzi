package com.platzi.android.rickandmorty.data

class CharacterRepository(
    private val remoteCharacterDataSource: RemoteCharacterDataSource,
    private val localCharacterDataSource: LocalCharacterDataSource
) {
    fun getAllCharacters(page: Int) = remoteCharacterDataSource.getAllCharacters(page)
    fun getAllFavoriteCharacters() = localCharacterDataSource.getAllFavoriteCharacters()
    fun getFavoriteCharacter(characterId: Int) = localCharacterDataSource.getFavoriteCharacter(characterId)
    fun updateFavoriteCharacter(character: com.platzi.android.rickandmorty.domain.Character) = localCharacterDataSource.updateFavoriteCharacter(character)
}

class EpisodeRepository(
    private val remoteEpisodeDataSource: RemoteEpisodeDataSource
) {
    fun getEpisodeFromCharacter(episodeUrl: List<String>) = remoteEpisodeDataSource.getEpisodeFromCharacter(episodeUrl)
}