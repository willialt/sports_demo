package com.lucas.sportsdemo.api.ncaamModels

data class StatusX(
    val clock: Double,
    val displayClock: String,
    val period: Int,
    val type: TypeX
)