package com.idcoding.hcitest.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/*
*  By Adya Bukhari
*  27 February, 2020
*  Email : Bukhariadbuk@gmail.com
*/

class ItemsModel (
    @SerializedName("article_title")
    @Expose
    val articleTitle: String? = null,
    @SerializedName("article_image")
    @Expose
    val articleImage: String? = null,
    @SerializedName("link")
    @Expose
    val link: String? = null,
    @SerializedName("product_name")
    @Expose
    val productName: String? = null,
    @SerializedName("product_image")
    @Expose
    val productImage: String? = null
)