package com.platzi.android.rickandmorty.usecases

import com.platzi.android.rickandmorty.api.*
import com.platzi.android.rickandmorty.data.CharacterRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class GetAllCharactersUseCase(
    private val characterRepository: CharacterRepository
) {

    fun invoke(currentPage: Int) = characterRepository.getAllCharacters(currentPage)
    
}