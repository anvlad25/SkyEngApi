package com.example.repository.network.data

import com.google.gson.annotations.SerializedName

class Meanings(
    @SerializedName("translation")
    val translation: Translation,

    @SerializedName("imageUrl")
    val imageUrl: String
)