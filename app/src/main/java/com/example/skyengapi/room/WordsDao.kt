package com.example.skyengapi.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface WordsDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertWord(word: HistoryWords)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertAllWords(words: List<HistoryWords>)

    @Query("SELECT * FROM history_words")
    fun selectAll(): List<HistoryWords>

    @Query("SELECT * FROM history_words WHERE word LIKE :word")
    fun selectWord(word: String): List<HistoryWords>
}