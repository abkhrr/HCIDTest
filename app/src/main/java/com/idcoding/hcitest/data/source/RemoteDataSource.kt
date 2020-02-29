package com.idcoding.hcitest.data.source

import com.idcoding.hcitest.data.model.DataResponse
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

/*
*  By Adya Bukhari
*  27 February, 2020
*  Email : Bukhariadbuk@gmail.com
*/

object RemoteDataSource : DataSource {

    private var mApiService = HCIApiService.getApiService()
    private var disposable: Disposable? = null

    override fun getData(
        onSuccess: (data: DataResponse) -> Unit,
        onError: (message: String) -> Unit
    ) {
        disposable = mApiService.getData()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ it ->
                onSuccess(it)
            }, {
                onError(it.message ?: "")
            })
    }

}