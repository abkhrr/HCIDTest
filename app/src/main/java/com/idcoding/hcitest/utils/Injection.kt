package com.idcoding.hcitest.utils

import android.content.Context
import com.idcoding.hcitest.data.HCIRepository
import com.idcoding.hcitest.data.source.RemoteDataSource

object Injection {

    private var mRepository: HCIRepository? = null

    fun createRepository(context: Context): HCIRepository {
        mRepository = HCIRepository(RemoteDataSource)
        return mRepository!!
    }

}