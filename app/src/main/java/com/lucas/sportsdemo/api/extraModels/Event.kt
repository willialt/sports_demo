package com.lucas.sportsdemo.api.extraModels

data class Event(
    val competitions: List<Competition>,
    val date: String,
    val id: String,
    val links: List<LinkXXX>,
    val name: String,
    val season: Season,
    val shortName: String,
    val status: StatusX,
    val uid: String,
    val weather: Weather,
    val week: Week
)