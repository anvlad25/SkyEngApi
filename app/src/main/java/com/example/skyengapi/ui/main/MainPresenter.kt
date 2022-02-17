package com.example.skyengapi.ui.main

import com.example.repository.network.data.WordsRepo
import com.example.skyengapi.scheduler.ISchedulerProvider
import com.example.skyengapi.scheduler.SchedulerProvider
import io.reactivex.rxjava3.disposables.CompositeDisposable
import moxy.MvpPresenter

class MainPresenter(
    private val wordsRepo: WordsRepo,
    private val schedulerProvider: ISchedulerProvider = SchedulerProvider()
) : MvpPresenter<MainView>() {
    private val disposables = CompositeDisposable()

    fun searchingWords(searchWord: String) {
        disposables.add(
            wordsRepo
                .getWords(searchWord)
                .observeOn(schedulerProvider.ui())
                .subscribeOn(schedulerProvider.io())
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