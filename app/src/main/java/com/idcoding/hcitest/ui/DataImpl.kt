package com.idcoding.hcitest.ui

import android.content.Context
import com.idcoding.hcitest.data.DataCallback
import com.idcoding.hcitest.data.model.ItemsModel
import com.idcoding.hcitest.utils.Injection
import java.util.*

class DataImpl internal constructor(private val context: Context){

    private val mRepository = Injection.createRepository(context)

    fun getData(callback: DataCallback) {
        // Get Data From Repository
        mRepository.getData(onSuccess = {
            val listItem = mutableListOf<ItemsModel>()
            if(it.data!!.isNotEmpty()){
                Collections.swap(it.data, 0, 1)
                for(section in it.data){
                    listItem.addAll(section.items!!)
                    callback.onSuccess(listItem)
                }
            }
        }, onError = {
            callback.onError(it)
        })
    }
}