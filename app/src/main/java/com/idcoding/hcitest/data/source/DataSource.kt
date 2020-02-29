package com.idcoding.hcitest.data.source

import com.idcoding.hcitest.data.model.DataResponse

interface DataSource {

    fun getData(
        onSuccess: (data: DataResponse) -> Unit = {},
        onError: (message: String) -> Unit = {}
    )
}