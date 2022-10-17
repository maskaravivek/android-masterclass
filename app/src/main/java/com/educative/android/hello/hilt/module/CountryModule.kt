package com.educative.android.hello.hilt.module

import com.educative.android.hello.interfaces.CountryListHiltInterface
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(ActivityComponent::class)
object CountryModule {

    @Provides
    fun provideAnalyticsService(converter: GsonConverterFactory): CountryListHiltInterface {
        val retrofit = Retrofit.Builder()
            .addConverterFactory(converter)
            .baseUrl(CountryListHiltInterface.BASE_URL)
            .build()
        return retrofit.create(CountryListHiltInterface::class.java)
    }

    @Provides
    fun provideGsonConverterFactory(): GsonConverterFactory {
        return GsonConverterFactory.create()
    }
}