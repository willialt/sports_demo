package com.lucas.sportsdemo.api.gameDetailModels

data class Start(
    val distance: Int,
    val down: Int,
    val downDistanceText: String,
    val possessionText: String,
    val shortDownDistanceText: String,
    val team: TeamXXXX,
    val yardLine: Int,
    val yardsToEndzone: Int
)