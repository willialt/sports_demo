package com.lucas.sportsdemo.api.models

data class Tags(
    val betSide: String,
    val betType: String,
    val gameId: Int,
    val league: String,
    val sport: String
)