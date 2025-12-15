package com.lucas.sportsdemo.api.gameDetailModels

data class Weather(
    val conditionId: String,
    val gust: Int,
    val highTemperature: Int,
    val link: LinkXXX,
    val lowTemperature: Int,
    val precipitation: Int,
    val temperature: Int
)