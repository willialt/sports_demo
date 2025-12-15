package com.lucas.sportsdemo.api.gameDetailModels

data class StartX(
    val clock: Clock,
    val period: PeriodX,
    val text: String,
    val yardLine: Int
)