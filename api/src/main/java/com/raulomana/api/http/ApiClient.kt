package com.raulomana.api.http

import com.raulomana.api.model.GIF
import io.reactivex.Single

interface ApiClient {
    fun getTrending(apiKey: String): Single<List<GIF>>
}