package com.rai.inbrazil.data.model

data class ClimaResponse(
    val current_weather: CurrentWeater
)

data class CurrentWeater(
    val temperature: Double,
    val windspeed: Double,
)
