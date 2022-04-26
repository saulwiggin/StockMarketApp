package com.plcoding.stockmarketapp.remote.dto

import okhttp3.ResponseBody
import retrofit2.http.GET
import retrofit2.http.Query

abstract class stockApi {

    @GET("query?function=LISTING_STATUS")
    abstract suspend fun getListings(
        @Query("apikey") apiKey: String = API_KEY
    ): ResponseBody

    companion object {
        const val API_KEY = "GE1U8J55JIN0PED6"
        const val BASE_URL = "https://alphavantage.co"
    }
}