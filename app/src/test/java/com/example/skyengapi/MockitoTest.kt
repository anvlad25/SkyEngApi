package com.example.skyengapi

import com.example.repository.network.data.Meanings
import com.example.repository.network.data.SkyEngWords
import com.example.repository.network.data.Translation
import com.example.repository.network.data.WordsRepo
import com.example.skyengapi.scheduler.TestSchedulerProvider
import com.example.skyengapi.ui.main.MainPresenter
import com.nhaarman.mockito_kotlin.verify
import io.reactivex.rxjava3.core.Single
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.MockitoAnnotations


class MockitoTest {
    private lateinit var presenter: MainPresenter
    private var schedulerProvider = TestSchedulerProvider()

    @Mock
    private lateinit var wordsRepo: WordsRepo

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        presenter = MainPresenter(wordsRepo, schedulerProvider)
    }

    @Test
    fun testWordsRepo() {
        val searchWord = "text"
        val translation = Translation("text")
        val meanings = listOf(Meanings(translation, "imageUrl"))
        val skyEngWords = listOf(SkyEngWords(1, "text", meanings))

        `when`(wordsRepo.getWords(searchWord)).thenReturn(Single.just(skyEngWords))
        presenter.searchingWords(searchWord)
        verify(wordsRepo, times(1)).getWords(searchWord)
    }
}