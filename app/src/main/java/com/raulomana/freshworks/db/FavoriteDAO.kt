package com.raulomana.freshworks.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.raulomana.freshworks.favs.Favorite
import io.reactivex.Flowable
import io.reactivex.Single

@Dao
interface FavoriteDAO {

    @Query("SELECT * FROM Favorite")
    fun getAll(): Flowable<List<Favorite>>

    @Insert
    fun insert(favorite: Favorite): Single<Long>

    @Delete
    fun delete(favorite: Favorite)

}