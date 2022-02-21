package com.example.androidmasterclass.interfaces

import com.example.androidmasterclass.models.CatFact
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET


interface CatInterface {

    @GET("facts/")
    fun getFacts(): Call<List<CatFact>>

    companion object {

        var BASE_URL = "https://cat-fact.herokuapp.com/"

        fun create(): CatInterface {
            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()
            return retrofit.create(CatInterface::class.java)
        }
    }
}