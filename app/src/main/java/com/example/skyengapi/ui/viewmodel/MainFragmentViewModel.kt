package com.example.skyengapi.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.repository.network.data.SkyEngWords
import com.example.repository.network.data.WordsRepo
import com.example.repository.room.HistoryWords
import com.example.repository.room.WordsDao
import com.example.skyengapi.Delegate
import io.reactivex.rxjava3.schedulers.Schedulers


class MainFragmentViewModel(val wordsRepo: WordsRepo, val wordsDao: WordsDao) : ViewModel() {
    private val _liveData = MutableLiveData<List<SkyEngWords>>()
    val liveData: MutableLiveData<List<SkyEngWords>> get() = _liveData

    fun getData(searchWord: String) {
        wordsRepo
            .getWords(searchWord)
            .observeOn(Schedulers.io())
            .subscribeOn(Schedulers.io())
            .subscribe(
                { skyEngWords ->
                    _liveData.postValue(skyEngWords)
                    wordsDao.insertWord(skyEngWordsToHistory(skyEngWords))
                }, { }
            )
    }

    private fun skyEngWordsToHistory(skyEngWords: List<SkyEngWords>): HistoryWords {
        var historyWords by Delegate()
        historyWords = HistoryWords(
            skyEngWords[0].text,
            skyEngWords[0].meanings[0].translation.text,
            skyEngWords[0].meanings[0].imageUrl
        )
        return historyWords
    }

}