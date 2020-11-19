package com.raulomana.api

import com.raulomana.api.http.ApiClient
import com.raulomana.api.http.HttpApiClient
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

@Module()
class ApiModule(val debugMode: Boolean, val baseUrl: String = "https://api.giphy.com/") {

    @Provides
    fun apiService(): APIService {
        val retrofit = Retrofit.Builder().run {
            addConverterFactory(GsonConverterFactory.create())
            addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            baseUrl(baseUrl)
            val okHttpClient = OkHttpClient.Builder().let {
                if(debugMode) {
                    val interceptor = HttpLoggingInterceptor()
                    interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
                    it.addInterceptor(interceptor)
                }
                it.build()
            }
            client(okHttpClient)
            build()
        }

        return retrofit.create(APIService::class.java)
    }

    @Provides
    fun apiClient(apiService: APIService) : ApiClient = HttpApiClient(apiService)

}