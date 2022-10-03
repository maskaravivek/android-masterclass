package com.educative.android.hello.interfaces

import com.educative.android.hello.models.Country
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET


interface CountryListKtCoroutineInterface {
    @GET("all/")
    suspend fun getCountries(): Response<List<Country>>

    companion object {
        var BASE_URL = "https://restcountries.com/v2/"

        fun create(): CountryListKtCoroutineInterface {
            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()
            return retrofit.create(CountryListKtCoroutineInterface::class.java)
        }
    }
}