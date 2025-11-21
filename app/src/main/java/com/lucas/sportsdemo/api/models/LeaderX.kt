package com.lucas.sportsdemo.api.models

data class LeaderX(
    val athlete: Athlete,
    val displayValue: String,
    val team: TeamX,
    val value: Double
)