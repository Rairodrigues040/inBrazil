package com.rai.inbrazil.service

import com.rai.inbrazil.data.model.ClimaResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ClimaApi {
    @GET("v1/forecast")
    suspend fun buscarClima(
        @Query("latitude") latitude: Double,
        @Query("longitude") longitude: Double,
        @Query("current_weather") currentWeather: Boolean = true
    ): ClimaResponse
}