package com.raulomana.api.model

import com.google.gson.annotations.SerializedName
import com.raulomana.api.model.GIF
import com.raulomana.api.model.Meta

data class APIResponse(
    @SerializedName("data") val data : List<GIF>,
    @SerializedName("meta") val meta : Meta
)