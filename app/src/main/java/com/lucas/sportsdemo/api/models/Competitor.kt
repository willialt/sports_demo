package com.lucas.sportsdemo.api.models

data class Competitor(
    val curatedRank: CuratedRank,
    val homeAway: String,
    val id: String,
    val leaders: List<LeaderXX>,
    val order: Int,
    val records: List<Record>,
    val score: String,
    val statistics: List<Any?>,
    val team: TeamXX,
    val type: String,
    val uid: String,
    val winner: Boolean
)