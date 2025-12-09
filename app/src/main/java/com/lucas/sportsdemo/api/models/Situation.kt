package com.lucas.sportsdemo.api.models


data class Situation(
    val awayTimeouts: Int,
    val distance: Int,
    val down: Int,
    val downDistanceText: String,
    val homeTimeouts: Int,
    val isRedZone: Boolean,
    val lastPlay: LastPlay,
    val possession: String,
    val possessionText: String,
    val shortDownDistanceText: String,
    val yardLine: Int
)