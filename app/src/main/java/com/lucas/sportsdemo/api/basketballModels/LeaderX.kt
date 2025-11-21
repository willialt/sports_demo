package com.lucas.sportsdemo.api.basketballModels

data class LeaderX(
    val athlete: Athlete,
    val displayValue: String,
    val team: TeamX,
    val value: Double
)