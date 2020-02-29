package com.idcoding.hcitest.data.model

import com.google.gson.annotations.SerializedName

/*
*  By Adya Bukhari
*  27 February, 2020
*  Email : Bukhariadbuk@gmail.com
*/

data class SectionModel(
    @SerializedName("section")
    val section: String,
    @SerializedName("section_title")
    val section_title: String,
    @SerializedName("items")
    val items: List<ItemsModel>?
)