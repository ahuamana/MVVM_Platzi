package com.platzi.android.rickandmorty.usecases

import com.platzi.android.rickandmorty.data.CharacterRepository
import com.platzi.android.rickandmorty.database.CharacterDao
import io.reactivex.Maybe
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class GetFavoriteCharacterStatusUseCase(
    private val repository: CharacterRepository
) {
    fun invoke(characterId: Int) = repository.getFavoriteCharacter(characterId)
}