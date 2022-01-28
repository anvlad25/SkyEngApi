package com.example.skyengapi

import com.example.repository.room.HistoryWords
import kotlin.reflect.KProperty

class Delegate {
    lateinit var historyWords: HistoryWords

    operator fun getValue(thisRef: Any?, property: KProperty<*>): HistoryWords = historyWords

    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: HistoryWords) {
        historyWords = value
        println("Print from Delegate")
    }
}