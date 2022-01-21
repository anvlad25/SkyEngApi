package com.example.skyengapi.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.skyengapi.room.HistoryWords
import com.example.skyengapi.room.WordsDao
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class HistoryFragmentViewModel(val wordsDao: WordsDao, val scope: CoroutineScope) : ViewModel() {
    private val _liveData = MutableLiveData<List<HistoryWords>>()
    val liveData: MutableLiveData<List<HistoryWords>> get() = _liveData

    init {
        scope.launch {
            _liveData.postValue(wordsDao.selectAll())
        }
    }
}