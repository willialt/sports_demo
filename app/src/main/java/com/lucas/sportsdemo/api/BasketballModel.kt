package com.lucas.sportsdemo.api

import com.lucas.sportsdemo.api.basketballModels.Day
import com.lucas.sportsdemo.api.basketballModels.Event
import com.lucas.sportsdemo.api.basketballModels.League
import com.lucas.sportsdemo.api.basketballModels.SeasonXX

data class BasketballModel(
    val day: Day,
    val events: List<Event>,
    val leagues: List<League>,
    val season: SeasonXX
)