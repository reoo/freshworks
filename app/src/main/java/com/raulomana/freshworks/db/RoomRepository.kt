package com.raulomana.freshworks.db

import com.raulomana.api.model.GIF
import com.raulomana.freshworks.favs.Favorite
import io.reactivex.Flowable
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class RoomRepository(private val db: AppDB): DBRepository {

    override fun addFavorite(gif: GIF): Single<Long> =
        db.favoriteDao().insert(Favorite(gif.id, gif.images.downsized.url))
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())

    override fun getFavorites(): Flowable<List<Favorite>> = db.favoriteDao().getAll()
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
}