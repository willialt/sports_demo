package com.lucas.sportsdemo.api.models

data class PointSpread(
    val away: AwayX,
    val displayName: String,
    val home: HomeX,
    val shortDisplayName: String
)