package com.raulomana.api.model

import com.google.gson.annotations.SerializedName

class ImageSizes(
    @SerializedName("original") val original : Image,
    @SerializedName("downsized") val downsized : Image
)