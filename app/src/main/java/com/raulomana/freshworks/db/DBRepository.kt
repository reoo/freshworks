package com.raulomana.freshworks.db

import com.raulomana.api.model.GIF
import com.raulomana.freshworks.favs.Favorite
import io.reactivex.Flowable
import io.reactivex.Single

interface DBRepository {

    fun addFavorite(gif: GIF): Single<Long>

    fun getFavorites(): Flowable<List<Favorite>>

}