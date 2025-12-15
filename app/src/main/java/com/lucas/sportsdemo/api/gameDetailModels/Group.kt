package com.lucas.sportsdemo.api.gameDetailModels

data class Group(
    val conferenceHeader: String,
    val divisionHeader: String,
    val header: String,
    val href: String,
    val standings: StandingsX
)