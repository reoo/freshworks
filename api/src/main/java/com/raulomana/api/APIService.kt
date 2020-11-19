package com.raulomana.api

import com.raulomana.api.model.APIResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface APIService {



    @GET("v1/gifs/trending")
    fun getTrending(@Query("api_key") apiKey: String): Single<APIResponse>

}