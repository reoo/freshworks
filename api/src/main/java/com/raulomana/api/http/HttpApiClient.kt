package com.raulomana.api.http

import com.raulomana.api.APIService
import com.raulomana.api.model.GIF
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class HttpApiClient(val apiService: APIService): ApiClient {
    override fun getTrending(apiKey: String): Single<List<GIF>> {
        return apiService.getTrending(apiKey).subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread()).map {
                it.data
            }
    }
}