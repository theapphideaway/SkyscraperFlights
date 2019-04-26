package com.theapphideaway.skyscraperflights.Services

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class FlightService {
    private val BASE_URL = "https://partners.api.skyscanner.net/apiservices/browsequotes/v1.0/"
    private var mRetrofit: Retrofit? = null

    init {

        val okHttpClient = OkHttpClient.Builder()
            .build()

        mRetrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()

        println(mRetrofit)
    }

    fun getHeadlineApi(): FlightInterface {
        return mRetrofit!!.create<FlightInterface>(FlightInterface::class.java!!)
    }
}