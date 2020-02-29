package com.idcoding.hcitest.data

import com.idcoding.hcitest.data.model.DataResponse
import com.idcoding.hcitest.data.source.DataSource
import com.idcoding.hcitest.data.source.RemoteDataSource

/*
*  By Adya Bukhari
*  27 February, 2020
*  Email : Bukhariadbuk@gmail.com
*/

class HCIRepository(
    private val remoteDataSource: RemoteDataSource
): DataSource {

    override fun getData(
        onSuccess: (data: DataResponse) -> Unit,
        onError: (message: String) -> Unit
    ) {
        remoteDataSource.getData(onSuccess, onError)
    }

}