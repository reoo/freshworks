package com.raulomana.freshworks.favs

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Favorite(
    @PrimaryKey
    val id: String,
    val url: String
)