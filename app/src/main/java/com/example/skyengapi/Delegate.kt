package com.example.skyengapi

import com.example.repository.room.HistoryWords
import kotlin.reflect.KProperty

class Delegate {
    lateinit var historyWords: List<HistoryWords>

    operator fun getValue(thisRef: Any?, property: KProperty<*>): List<HistoryWords> = historyWords

    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: List<HistoryWords>) {
        historyWords = value
        println("Print from Delegate")
    }
}