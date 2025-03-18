package com.example.proyectodivisas.network

import com.example.proyectodivisas.model.ExchangeRatesResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ExchangeRateApi {
    @GET("c713991b4f513b1640a3c738/latest/USD")
    suspend fun getLatestRates(): ExchangeRatesResponse
}