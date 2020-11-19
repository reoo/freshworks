package com.raulomana.api.model

import com.google.gson.annotations.SerializedName

data class GIF(
    @SerializedName("type") val type : String,
    @SerializedName("id") val id : String,
    @SerializedName("url") val url : String,
    @SerializedName("slug") val slug : String,
    @SerializedName("embed_url") val embed_url : String,
    @SerializedName("source") val source : String,
    @SerializedName("title") val title : String,
    @SerializedName("images") val images : ImageSizes,
    var favorite: Boolean
)