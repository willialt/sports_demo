package com.lucas.sportsdemo.api.extraModels

data class livefootball(
    val events: List<Event>,
    val leagues: List<League>,
    val provider: Provider,
    val season: SeasonXX,
    val week: WeekX
)