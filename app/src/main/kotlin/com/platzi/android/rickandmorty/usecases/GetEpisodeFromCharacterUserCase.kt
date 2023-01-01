package com.platzi.android.rickandmorty.usecases

import com.platzi.android.rickandmorty.api.EpisodeRequest
import com.platzi.android.rickandmorty.api.EpisodeServer
import com.platzi.android.rickandmorty.api.EpisodeService
import com.platzi.android.rickandmorty.api.toEpisodeDomain
import com.platzi.android.rickandmorty.presentation.CharacterDetailViewModel
import com.platzi.android.rickandmorty.presentation.utils.Event
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class GetEpisodeFromCharacterUserCase(
    private val episodeRequest: EpisodeRequest
) {
    fun invoke(episodeUrlList: List<String>) = Observable.fromIterable(episodeUrlList)
        .flatMap { episode: String ->
            episodeRequest.baseUrl = episode
            episodeRequest
                .getService<EpisodeService>()
                .getEpisode()
                .map(EpisodeServer::toEpisodeDomain)
                .toObservable()
        }
        .toList()
        .observeOn(AndroidSchedulers.mainThread())
        .subscribeOn(Schedulers.io())
}