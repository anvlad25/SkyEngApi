package com.example.skyengapi.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.skyengapi.data.SkyEngWords
import com.example.skyengapi.data.WordsRepo
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers


class MainFragmentViewModel(val wordsRepo: WordsRepo) : ViewModel() {
    val liveData = MutableLiveData<List<SkyEngWords>>()

    fun getData(searchWord: String) {
        wordsRepo
            .getWords(searchWord)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe(
                {
                    liveData.postValue(it)
                }, { }
            )

    }
}