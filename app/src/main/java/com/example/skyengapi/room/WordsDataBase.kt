package com.example.skyengapi.room

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [HistoryWords::class], version = 1, exportSchema = true)
abstract class WordsDataBase : RoomDatabase() {
    abstract fun wordsDao(): WordsDao
}