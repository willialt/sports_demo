package com.lucas.sportsdemo.api.models

data class Weather(
    val conditionId: String,
    val displayValue: String,
    val highTemperature: Int,
    val link: Link,
    val temperature: Int
)