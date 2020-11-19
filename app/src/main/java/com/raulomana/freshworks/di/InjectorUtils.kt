package com.raulomana.freshworks.di

import android.app.Activity
import android.app.Application
import android.content.Context
import androidx.fragment.app.Fragment
import com.raulomana.freshworks.AppApplication

class InjectorUtils {

    companion object {

        fun getInjector(application: Application): AppComponent {
            if (application is AppApplication) {
                return application.appComponent
            }
            throw IllegalStateException("application must be instance of app application")
        }

        fun getInjector(context: Context): AppComponent {
            return getInjector(context.applicationContext as Application)
        }

        fun getInjector(activity: Activity): AppComponent {
            return getInjector(activity.application)
        }

        fun getInjector(fragment: Fragment): AppComponent {
            return getInjector(fragment.requireActivity())
        }

    }

}