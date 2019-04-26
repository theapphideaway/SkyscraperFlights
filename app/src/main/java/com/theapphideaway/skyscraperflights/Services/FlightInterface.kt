package com.theapphideaway.skyscraperflights.Services

import com.theapphideaway.skyscraperflights.Model.FlightResponse
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface FlightInterface {
    @GET("US/USD/en-US/LAX/STOC/anytime/anytime")
    fun getSearchedHeadlines(
        @Query("apikey") apiKey: String
    ): Deferred<FlightResponse>
}