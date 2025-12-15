package com.lucas.sportsdemo.api.gameDetailModels

data class Player(
    val displayOrder: Int,
    val statistics: List<Statistic>,
    val team: TeamX
)