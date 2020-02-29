package com.idcoding.hcitest.data

import com.idcoding.hcitest.data.model.ItemsModel

interface DataCallback{
    fun onSuccess(data: MutableList<ItemsModel>)
    fun onError(message: String)
}

interface ViewHelper{
    fun showProgress()
    fun hideProgress()
}