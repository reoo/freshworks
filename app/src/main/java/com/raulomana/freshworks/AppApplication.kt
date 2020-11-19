package com.raulomana.freshworks

import android.app.Application
import androidx.room.Room
import com.raulomana.api.ApiModule
import com.raulomana.freshworks.db.AppDB
import com.raulomana.freshworks.db.DBModule
import com.raulomana.freshworks.di.AppComponent
import com.raulomana.freshworks.di.AppModule
import com.raulomana.freshworks.di.DaggerAppComponent

class AppApplication: Application() {
    lateinit var appComponent: AppComponent
//    val appDB: AppDB by lazy {
//        Room.databaseBuilder(
//            this@AppApplication,
//            AppDB::class.java,
//            AppDB.DB_NAME
//        ).build()
//    }

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(this))
            .dBModule(DBModule(this))
            .apiModule(ApiModule(BuildConfig.DEBUG))
            .build()

    }

}