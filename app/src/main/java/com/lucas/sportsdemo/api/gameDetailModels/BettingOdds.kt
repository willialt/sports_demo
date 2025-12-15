package com.lucas.sportsdemo.api.gameDetailModels

data class BettingOdds(
    val awayTeamOdds: AwayTeamOdds,
    val homeTeamOdds: HomeTeamOdds,
    val details: String,
    val spread: Double,
    val overUnder: Double,
    val overOdds: Double,
    val underOdds: Double,
)
