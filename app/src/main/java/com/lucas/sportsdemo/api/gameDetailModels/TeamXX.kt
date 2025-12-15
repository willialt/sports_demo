package com.lucas.sportsdemo.api.gameDetailModels

data class TeamXX(
    val displayOrder: Int,
    val homeAway: String,
    val statistics: List<StatisticX>,
    val team: TeamX
)