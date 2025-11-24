package com.lucas.sportsdemo.api

import com.lucas.sportsdemo.api.models.Event
import com.lucas.sportsdemo.api.models.League
import com.lucas.sportsdemo.api.models.SeasonXX
import com.lucas.sportsdemo.api.models.WeekX


data class SportsModel(
    val events: List<Event>,
    val leagues: List<League>,
    val season: SeasonXX,
    val week: WeekX
)