package com.lucas.sportsdemo.api.ncaamModels

data class LeaderX(
    val athlete: Athlete,
    val displayValue: String,
    val team: TeamX,
    val value: Double
)