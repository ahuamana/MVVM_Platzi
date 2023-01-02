package com.platzi.android.rickandmorty.database

import com.platzi.android.rickandmorty.data.LocalCharacterDataSource
import io.reactivex.Maybe
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class CharacterRoomSource(
    database: CharacterDatabase
): LocalCharacterDataSource {
    private val characterDao by lazy {
        database.characterDao()
    }

    override fun getAllFavoriteCharacters() = characterDao
        .getAllFavoriteCharacters()
        .map(List<CharacterEntity>::toCharacterDomainList)
        .onErrorReturn { emptyList() }
        .subscribeOn(Schedulers.io())

    override fun getFavoriteCharacter(characterId: Int) = characterDao.getCharacterById(characterId)
        .isEmpty
        .flatMapMaybe { isEmpty ->
            Maybe.just(!isEmpty)
        }
        .observeOn(AndroidSchedulers.mainThread())
        .subscribeOn(Schedulers.io())

    override fun updateFavoriteCharacter(character: com.platzi.android.rickandmorty.domain.Character): Maybe<Boolean> {
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