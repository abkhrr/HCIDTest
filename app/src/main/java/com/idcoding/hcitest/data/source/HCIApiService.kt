package com.idcoding.hcitest.data.source

import com.idcoding.hcitest.BuildConfig
import com.idcoding.hcitest.data.model.DataResponse
import io.reactivex.Observable
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import java.util.concurrent.TimeUnit

/*
*  By Adya Bukhari
*  27 February, 2020
*  Email : Bukhariadbuk@gmail.com
*/

internal interface HCIApiService{

    @GET("/home")
    fun getData(): Observable<DataResponse>

    companion object Factory{

        fun getApiService(): HCIApiService {

            val mLoggingInterceptor = HttpLoggingInterceptor()
            mLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

            val mClient = if (BuildConfig.DEBUG) {
                OkHttpClient.Builder()
                    .addInterceptor(mLoggingInterceptor)
                    .addInterceptor { chain ->
                        val request = chain.request()
                        val newRequest = request.newBuilder().build()
                        chain.proceed(newRequest)
                    }
                    .readTimeout(120, TimeUnit.SECONDS)
                    .connectTimeout(120, TimeUnit.SECONDS)
                    .build()
            } else {
                OkHttpClient.Builder()
                    .addInterceptor { chain ->
                        val request = chain.request()
                        val newRequest = request.newBuilder().build()
                        chain.proceed(newRequest)
                    }
                    .readTimeout(120, TimeUnit.SECONDS)
                    .connectTimeout(120, TimeUnit.SECONDS)
                    .build()
            }

            val mRetrofit = Retrofit.Builder()
                .baseUrl(BuildConfig.BASE_API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(mClient)
                .build()

            return mRetrofit.create(HCIApiService::class.java)
        }
    }
}