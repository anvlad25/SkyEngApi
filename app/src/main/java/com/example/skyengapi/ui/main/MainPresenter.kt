package com.example.skyengapi.ui.main

import com.example.repository.network.data.WordsRepo
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers
import moxy.MvpPresenter

class MainPresenter(private val wordsRepo: WordsRepo) : MvpPresenter<MainView>() {
    private val disposables = CompositeDisposable()

    fun searchingWords(searchWord: String) {
        disposables.add(
            wordsRepo
                .getWords(searchWord)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(
                    { words ->
                        viewState.showWords(words)
                        viewState.updateList()
                    }, { error ->
                        viewState.showError(error)
                    }
                )
        )
    }

    override fun onDestroy() {
        disposables.dispose()
    }
}