package com.learn.distonary.presetner

import android.view.View
import com.learn.distonary.model.AppState

interface Presenter<T: AppState, V: View> {

    fun attachView(view: V)

    fun detachView(view: V)

    fun getData(word: String, isOnline: Boolean)

}