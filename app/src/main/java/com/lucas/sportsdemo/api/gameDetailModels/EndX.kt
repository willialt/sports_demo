package com.lucas.sportsdemo.api.gameDetailModels

data class EndX(
    val clock: Clock,
    val period: PeriodX,
    val text: String,
    val yardLine: Int
)