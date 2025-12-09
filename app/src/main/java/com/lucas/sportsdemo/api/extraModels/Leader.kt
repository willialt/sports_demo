package com.lucas.sportsdemo.api.extraModels

data class Leader(
    val abbreviation: String,
    val displayName: String,
    val leaders: List<LeaderX>,
    val name: String,
    val shortDisplayName: String
)