package com.lucas.sportsdemo.api.basketballModels

data class NbaEvent(
    val competitions: List<Competition>,
    val date: String,
    val id: String,
    val links: List<LinkXX>,
    val name: String,
    val season: Season,
    val shortName: String,
    val status: StatusX,
    val uid: String
)