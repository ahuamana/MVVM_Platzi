package com.platzi.android.rickandmorty.usecases

import com.platzi.android.rickandmorty.data.CharacterRepository
import com.platzi.android.rickandmorty.database.CharacterDao
import com.platzi.android.rickandmorty.database.CharacterEntity
import com.platzi.android.rickandmorty.database.toCharacterDomain
import com.platzi.android.rickandmorty.database.toCharacterDomainList
import io.reactivex.schedulers.Schedulers

class GetAllFavoriteCharactersUseCase(
    private val characterRepository: CharacterRepository
) {
    fun invoke() = characterRepository.getAllFavoriteCharacters()
}