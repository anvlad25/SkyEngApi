package com.example.skyengapi

import com.example.repository.network.data.SkyEngWords
import com.example.repository.room.HistoryWords

class TransformToHistory {
    fun skyEngWordsToHistory(skyEngWords: List<SkyEngWords>): MutableList<HistoryWords> {
        //var historyWords by Delegate()
        val historyWords = mutableListOf<HistoryWords>()

        skyEngWords.forEach {
            historyWords.add(
                HistoryWords(
                    it.text,
                    it.meanings[0].translation.text,
                    it.meanings[0].imageUrl
                )
            )
        }
        return historyWords
    }
}