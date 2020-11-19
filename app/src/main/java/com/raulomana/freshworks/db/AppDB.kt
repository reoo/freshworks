package com.raulomana.freshworks.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.raulomana.freshworks.favs.Favorite

@Database(entities = [Favorite::class], version = 1)
abstract class AppDB: RoomDatabase() {

    abstract fun favoriteDao(): FavoriteDAO

    companion object {
        const val DB_NAME = "favs.db"
    }

}