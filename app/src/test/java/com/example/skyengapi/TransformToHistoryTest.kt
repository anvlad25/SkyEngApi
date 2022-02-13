package com.example.skyengapi

import com.example.repository.network.data.Meanings
import com.example.repository.network.data.SkyEngWords
import com.example.repository.network.data.Translation
import com.example.repository.room.HistoryWords
import org.junit.Assert.*
import org.junit.Test

class TransformToHistoryTest {
    @Test
    fun transformToHistory_ToHistory_Equals() {
        val translation = Translation("text")
        val meanings = listOf(Meanings(translation, "imageUrl"))
        val skyEngWords = listOf(SkyEngWords(1, "text", meanings))
        val historyWords = HistoryWords("text", "text", "imageUrl")

        assertEquals(TransformToHistory().skyEngWordsToHistory(skyEngWords)[0], historyWords)
    }

    @Test
    fun transformToHistory_ToHistory_NotEquals() {
        val translation = Translation("text 2")
        val meanings = listOf(Meanings(translation, "imageUrl"))
        val skyEngWords = listOf(SkyEngWords(1, "text", meanings))
        val historyWords = HistoryWords("text", "text", "imageUrl")

        assertNotEquals(TransformToHistory().skyEngWordsToHistory(skyEngWords)[0], historyWords)
    }

    @Test
    fun transformToHistory_ToHistory_ArrayEquals() {
        val translation = Translation("text")
        val meanings = listOf(Meanings(translation, "imageUrl"))
        val skyEngWords = listOf(
            SkyEngWords(1, "text1", meanings),
            SkyEngWords(2, "text2", meanings)
        )
        val historyWords = arrayOf(
            HistoryWords("text1", "text", "imageUrl"),
            HistoryWords("text2", "text", "imageUrl")
        )
        assertArrayEquals(TransformToHistory().skyEngWordsToHistory(skyEngWords).toTypedArray(), historyWords)
    }

    @Test
    fun transformToHistory_ToHistory_NullError() {
        val translation = Translation("text 2")
        val meanings = listOf(Meanings(translation, "imageUrl"))
        val skyEngWords = listOf(SkyEngWords(1, "text", meanings))

        assertNull(TransformToHistory().skyEngWordsToHistory(skyEngWords)[0])
    }

    @Test
    fun transformToHistory_ToHistory_NotNull() {
        val translation = Translation("text 2")
        val meanings = listOf(Meanings(translation, "imageUrl"))
        val skyEngWords = listOf(SkyEngWords(1, "text", meanings))

        assertNotNull(TransformToHistory().skyEngWordsToHistory(skyEngWords)[0])
    }

    @Test
    fun transformToHistory_ToHistory_SameError() {
        val translation = Translation("text 2")
        val meanings = listOf(Meanings(translation, "imageUrl"))
        val skyEngWords = listOf(SkyEngWords(1, "text", meanings))
        val historyWords = HistoryWords("text", "text", "imageUrl")

        assertSame(TransformToHistory().skyEngWordsToHistory(skyEngWords)[0], historyWords)
    }
}