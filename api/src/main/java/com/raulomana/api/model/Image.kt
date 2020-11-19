package com.raulomana.api.model

import com.google.gson.annotations.SerializedName

data class Image(
    @SerializedName("height") val height : Int,
    @SerializedName("width") val width : Int,
    @SerializedName("size") val size : Int,
    @SerializedName("url") val url : String
)