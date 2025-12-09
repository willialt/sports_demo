package com.lucas.sportsdemo.api.models

data class Probability(
    val awayWinPercentage: Double,
    val homeWinPercentage: Double,
    val secondsLeft: Int,
    val tiePercentage: Double
)