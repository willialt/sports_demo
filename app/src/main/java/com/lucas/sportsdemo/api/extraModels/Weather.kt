package com.lucas.sportsdemo.api.extraModels

data class Weather(
    val conditionId: String,
    val displayValue: String,
    val highTemperature: Int,
    val link: LinkXXX,
    val temperature: Int
)