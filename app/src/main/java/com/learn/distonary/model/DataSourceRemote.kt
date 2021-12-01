package com.learn.distonary.model

import io.reactivex.rxjava3.core.Observable

class DataSourceRemote(private val remoteProvider: RetrofitImp = RetrofitImp()):DataSourse<List<DataModel>> {
    override fun getData(word: String): Observable<List<DataModel>> {
        return remoteProvider.getData(word)
    }
}

Надо реализовать Интерактор