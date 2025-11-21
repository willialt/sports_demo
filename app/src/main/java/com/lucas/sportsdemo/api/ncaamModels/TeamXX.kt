package com.lucas.sportsdemo.api.ncaamModels

data class TeamXX(
    val abbreviation: String,
    val alternateColor: String,
    val color: String,
    val conferenceId: String,
    val displayName: String,
    val id: String,
    val isActive: Boolean,
    val links: List<LinkX>,
    val location: String,
    val logo: String,
    val name: String,
    val shortDisplayName: String,
    val uid: String,
    val venue: Venue
)