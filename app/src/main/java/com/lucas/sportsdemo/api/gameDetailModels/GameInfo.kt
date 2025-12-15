package com.lucas.sportsdemo.api.gameDetailModels

data class GameInfo(
    val officials: List<Official>,
    val venue: Venue,
    val weather: Weather
)