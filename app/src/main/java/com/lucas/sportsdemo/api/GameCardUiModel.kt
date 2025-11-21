package com.lucas.sportsdemo.api

data class GameCardUiModel(
    val team1: String,
    val team2: String,
    val team1Record: String?,
    val team2Record: String?,
    val team1Rank: Int?,
    val team2Rank: Int?,
    val team1Abr: String?,
    val team2Abr: String?,
    val startTime: String?,
    val spread: Double?,
    val team1Logo: String?,
    val team2Logo: String?,
    val team1Color: String?,
    val team2Color: String?,
    val broadcast: String? = null
)