package com.learn.distonary.model

import io.reactivex.rxjava3.core.Observable

interface DataSourse<T> {
    fun getData(word: String): Observable<T>

}