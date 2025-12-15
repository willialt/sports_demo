package com.lucas.sportsdemo.api.gameDetailModels

data class Participant(
    val athlete: AthleteXX,
    val playStatistics: PlayStatistics,
    val stats: List<Any?>,
    val type: String
)