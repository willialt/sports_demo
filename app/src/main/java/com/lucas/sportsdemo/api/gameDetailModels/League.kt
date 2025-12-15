package com.lucas.sportsdemo.api.gameDetailModels

data class League(
    val abbreviation: String,
    val id: String,
    val isTournament: Boolean,
    val links: List<LinkX>,
    val logos: List<LogoXXXX>,
    val name: String,
    val slug: String,
    val uid: String
)