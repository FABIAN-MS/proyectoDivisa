package com.example.proyectodivisas.retrofit



import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ExchangeRateService {

    @GET("v6/834635aa2b5f8b8837fc15fc/latest/{baseCode}")
    suspend fun getLatestRates(@Path("baseCode") baseCode: String): Response<ExchangeRateResponse>
}