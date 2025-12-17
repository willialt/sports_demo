package com.lucas.sportsdemo.api.gameDetailModels

data class Predictor(
    val homeTeam: HomeTeam,
    val awayTeam: AwayTeam
)

data class HomeTeam(
    val gameProjection: String
)

data class AwayTeam(
    val gameProjection: String
)
