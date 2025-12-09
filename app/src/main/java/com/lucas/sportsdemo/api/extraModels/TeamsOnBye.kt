package com.lucas.sportsdemo.api.extraModels

data class TeamsOnBye(
    val abbreviation: String,
    val displayName: String,
    val id: String,
    val isActive: Boolean,
    val links: List<Link>,
    val location: String,
    val logo: String,
    val name: String,
    val shortDisplayName: String,
    val uid: String
)