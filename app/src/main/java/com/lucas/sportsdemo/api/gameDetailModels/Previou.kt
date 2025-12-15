package com.lucas.sportsdemo.api.gameDetailModels

data class Previou(
    val description: String,
    val displayResult: String,
    val end: EndX,
    val id: String,
    val isScore: Boolean,
    val offensivePlays: Int,
    val plays: List<PlayX>,
    val result: String,
    val shortDisplayResult: String,
    val start: StartX,
    val team: TeamXXXXXXXX,
    val timeElapsed: TimeElapsed,
    val yards: Int
)