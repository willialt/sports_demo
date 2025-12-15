package com.lucas.sportsdemo.api.gameDetailModels

data class Standings(
    val fullViewLink: FullViewLink,
    val groups: List<Group>,
    val header: String,
    val isSameConference: Boolean
)