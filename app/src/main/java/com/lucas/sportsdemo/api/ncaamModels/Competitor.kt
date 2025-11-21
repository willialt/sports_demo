package com.lucas.sportsdemo.api.ncaamModels

data class Competitor(
    val curatedRank: CuratedRank,
    val homeAway: String,
    val id: String,
    val leaders: List<Leader>,
    val linescores: List<Linescore>,
    val order: Int,
    val records: List<Record>,
    val score: String,
    val statistics: List<Statistic>,
    val team: TeamXX,
    val type: String,
    val uid: String,
    val winner: Boolean
)