package com.raulomana.freshworks.di

import com.raulomana.freshworks.AppApplication
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(val appApplication: AppApplication) {

    @Singleton
    @Provides
    fun appApplication(): AppApplication = appApplication

}