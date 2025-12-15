package com.lucas.sportsdemo.api.gameDetailModels

data class Winprobability(
    val homeWinPercentage: Double,
    val playId: String,
    val tiePercentage: Double
)