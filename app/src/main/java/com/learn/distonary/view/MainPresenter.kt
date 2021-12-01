package com.learn.distonary.view

import android.view.View
import com.learn.distonary.model.AppState
import com.learn.distonary.presetner.Presenter
import io.reactivex.rxjava3.disposables.CompositeDisposable

class MainPresenter<T:AppState, V:View>(protected val compositeDisposable: CompositeDisposable = CompositeDisposable()) : Presenter<T, V> {


    private var currentView: V? = null

    override fun attachView(view: V) {
        if (view != null){
            currentView = view
        }
    }

    override fun detachView(view: V) {
        if (view == currentView){
            view
        }
    }

    override fun getData(word: String, isOnline: Boolean) {
        compositeDisposable.add(

        )
    }

}