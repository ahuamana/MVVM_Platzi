package com.platzi.android.rickandmorty.usecases

import com.platzi.android.rickandmorty.database.CharacterDao
import com.platzi.android.rickandmorty.database.CharacterEntity
import com.platzi.android.rickandmorty.database.toCharacterEntity
import io.reactivex.Maybe
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class ValidateFavoriteCharacterStatusUseCase(
    private val characterDao: CharacterDao
) {

    fun invoke(character:com.platzi.android.rickandmorty.domain.Character): Maybe<Boolean>{
        val characterEntity = character.toCharacterEntity()
        return characterDao.getCharacterById(characterEntity.id)
            .isEmpty
            .flatMapMaybe { isEmpty ->
                if(isEmpty){
                    characterDao.insertCharacter(characterEntity)
                }else{
                    characterDao.deleteCharacter(characterEntity)
                }
                Maybe.just(isEmpty)
            }
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())

    }
}