package com.educative.android.hello.interfaces

import android.content.Context
import com.educative.android.hello.interceptor.CacheInterceptor
import com.educative.android.hello.models.Country
import okhttp3.Cache
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import java.io.File


interface CountryListCacheInterface {
    @GET("all/")
    fun getCountries(): Call<List<Country>>

    companion object {
        var BASE_URL = "https://restcountries.com/v2/"

        fun create(context: Context): CountryListCacheInterface {
            val httpCacheDirectory = File(context.cacheDir, "http-cache")
            val cacheSize: Long = 10 * 1024 * 1024 // 10 MiB

            val cache = Cache(httpCacheDirectory, cacheSize)
            val okHttpClient = OkHttpClient.Builder()
                .addNetworkInterceptor(CacheInterceptor())
                .cache(cache)
                .build()

            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .client(okHttpClient)
                .build()
            return retrofit.create(CountryListCacheInterface::class.java)
        }
    }
}