package com.lucas.sportsdemo.api.models

data class LeaderXX(
    val abbreviation: String,
    val displayName: String,
    val leaders: List<LeaderX>,
    val name: String,
    val shortDisplayName: String
)