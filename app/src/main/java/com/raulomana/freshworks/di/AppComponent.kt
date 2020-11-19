package com.raulomana.freshworks.di

import com.raulomana.api.ApiModule
import com.raulomana.freshworks.db.DBModule
import com.raulomana.freshworks.favs.FavsFragment
import com.raulomana.freshworks.search.SearchFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ApiModule::class, AppModule::class, DBModule::class])
interface AppComponent {

    fun inject(fragment: SearchFragment)
    fun inject(fragment: FavsFragment)

}