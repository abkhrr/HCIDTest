package com.idcoding.hcitest.data.source

import com.idcoding.hcitest.data.model.DataResponse

/*
*  By Adya Bukhari
*  27 February, 2020
*  Email : Bukhariadbuk@gmail.com
*/

interface DataSource {

    fun getData(
        onSuccess: (data: DataResponse) -> Unit = {},
        onError: (message: String) -> Unit = {}
    )
}