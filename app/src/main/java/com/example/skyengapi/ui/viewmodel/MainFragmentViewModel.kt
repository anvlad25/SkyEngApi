package com.example.skyengapi.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.skyengapi.data.SkyEngWords
import com.example.skyengapi.data.WordsRepo
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

class MainFragmentViewModel : ViewModel(), HasAndroidInjector {
    @Inject
    lateinit var androidInjector: DispatchingAndroidInjector<Any>

    @Inject
    lateinit var wordsRepo: WordsRepo

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

    override fun androidInjector(): AndroidInjector<Any> {
        return androidInjector
    }
}