package com.example.repository.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "history_words")
data class HistoryWords(
    @field:PrimaryKey
    @field:ColumnInfo(name = "word") var word: String,
    @field:ColumnInfo(name = "description") var description: String,
    @field:ColumnInfo(name = "image_url") var imageUrl: String
)