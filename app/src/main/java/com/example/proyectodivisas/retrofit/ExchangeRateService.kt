package com.example.proyectodivisas.retrofit



import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ExchangeRateService {

    @GET("v6/c05011d4ff8ab7037ac5946b/latest/{baseCode}")
    suspend fun getLatestRates(@Path("baseCode") baseCode: String): Response<ExchangeRateResponse>
}