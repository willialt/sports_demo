package com.lucas.sportsdemo.api.extraModels

data class Competitor(
    val homeAway: String,
    val id: String,
    val linescores: List<Linescore>,
    val order: Int,
    val records: List<Record>,
    val score: String,
    val statistics: List<Any>,
    val team: Team,
    val type: String,
    val uid: String,
    val winner: Boolean
)