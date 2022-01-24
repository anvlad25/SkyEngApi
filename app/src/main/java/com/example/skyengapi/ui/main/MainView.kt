package com.example.skyengapi.ui.main

import com.example.repository.network.data.SkyEngWords
import moxy.MvpView
import moxy.viewstate.strategy.alias.SingleState

@SingleState
interface MainView : MvpView {
    fun updateList()
    fun showWords(words: List<SkyEngWords>)
    fun showError(error: Throwable)
}