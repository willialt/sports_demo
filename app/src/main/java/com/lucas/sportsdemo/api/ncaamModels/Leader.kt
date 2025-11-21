package com.lucas.sportsdemo.api.ncaamModels

data class Leader(
    val abbreviation: String,
    val displayName: String,
    val leaders: List<LeaderX>,
    val name: String,
    val shortDisplayName: String
)