package com.raulomana.freshworks.db

import androidx.room.Room
import com.raulomana.freshworks.AppApplication
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DBModule(application: AppApplication) {
    private val db: AppDB = Room.databaseBuilder(
        application,
        AppDB::class.java,
        AppDB.DB_NAME
    ).build()

    @Singleton
    @Provides
    fun db(): AppDB = db

    @Singleton
    @Provides
    fun dbRepository(db: AppDB): DBRepository = RoomRepository(db)

}