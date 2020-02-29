package com.idcoding.hcitest.data.model

import com.google.gson.annotations.SerializedName

/*
*  By Adya Bukhari
*  27 February, 2020
*  Email : Bukhariadbuk@gmail.com
*/

data class DataResponse(
    @SerializedName("data")
    val data: List<SectionModel>?
)