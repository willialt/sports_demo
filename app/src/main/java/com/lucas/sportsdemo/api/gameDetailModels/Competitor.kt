package com.lucas.sportsdemo.api.gameDetailModels

data class Competitor(
    val homeAway: String,
    val id: String,
    val linescores: List<Linescore>,
    val order: Int,
    val possession: Boolean,
    val record: List<Record>,
    val score: String,
    val team: TeamXXXXXXXXXXXXX,
    val timeoutsUsed: Int,
    val uid: String,
    val winner: Boolean?,
    val curatedRank: CuratedRank?
)