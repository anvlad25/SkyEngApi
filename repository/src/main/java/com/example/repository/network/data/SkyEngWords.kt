package com.example.repository.network.data

import com.google.gson.annotations.SerializedName

class SkyEngWords(
    @SerializedName("id")
    val id: Int,

    @SerializedName("text")
    val text: String,

    @SerializedName("meanings")
    val meanings: List<Meanings>
)