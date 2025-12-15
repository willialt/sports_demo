package com.lucas.sportsdemo.api.gameDetailModels

data class ScoringPlay(
    val awayScore: Int,
    val clock: ClockXXXXX,
    val homeScore: Int,
    val id: String,
    val period: Period,
    val scoringType: ScoringType,
    val team: Team,
    val text: String,
    val type: Type
)