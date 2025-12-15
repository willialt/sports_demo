package com.lucas.sportsdemo.api.gameDetailModels

data class TeamParticipant(
    val id: String,
    val order: Int,
    val playStatistics: PlayStatistics,
    val statistics: Statistics,
    val team: TeamXXXXXXX,
    val type: String
)