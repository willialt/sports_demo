package com.lucas.sportsdemo.api.gameDetailModels

data class Team(
    val abbreviation: String,
    val displayName: String,
    val id: String,
    val links: List<Link>,
    val logo: String,
    val logos: List<Logo>,
    val uid: String
)