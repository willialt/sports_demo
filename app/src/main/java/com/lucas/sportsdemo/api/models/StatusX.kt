package com.lucas.sportsdemo.api.models

data class StatusX(
    val clock: Double,
    val displayClock: String,
    val period: Int,
    val type: TypeX
)