package com.lucas.sportsdemo.api.extraModels

data class Athlete(
    val active: Boolean,
    val displayName: String,
    val fullName: String,
    val headshot: String,
    val id: String,
    val jersey: String,
    val links: List<LinkX>,
    val position: Position,
    val shortName: String,
    val team: TeamXX
)