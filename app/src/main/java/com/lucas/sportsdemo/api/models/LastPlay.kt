package com.lucas.sportsdemo.api.models



data class LastPlay(
    val athletesInvolved: List<AthletesInvolved>,
    val drive: Drive,
    val end: End,
    val id: String,
    val probability: Probability,
    val scoreValue: Int,
    val start: Start,
    val statYardage: Int,
    val team: TeamXX,
    val text: String,
    val type: TypeX
)