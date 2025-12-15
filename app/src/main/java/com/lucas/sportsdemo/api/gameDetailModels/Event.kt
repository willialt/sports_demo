package com.lucas.sportsdemo.api.gameDetailModels

data class Event(
    val description: String,
    val id: Int,
    val league: String,
    val links: LinksXX,
    val sport: String
)