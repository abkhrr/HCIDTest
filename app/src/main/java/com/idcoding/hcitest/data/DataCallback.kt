package com.idcoding.hcitest.data

import com.idcoding.hcitest.data.model.ItemsModel

/*
*  By Adya Bukhari
*  27 February, 2020
*  Email : Bukhariadbuk@gmail.com
*/

interface DataCallback{
    fun onSuccess(data: MutableList<ItemsModel>)
    fun onError(message: String)
}

interface ViewHelper{
    fun showProgress()
    fun hideProgress()
}