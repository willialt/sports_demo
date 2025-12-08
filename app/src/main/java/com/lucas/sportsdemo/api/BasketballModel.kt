package com.lucas.sportsdemo.api

import com.lucas.sportsdemo.api.basketballModels.Day
import com.lucas.sportsdemo.api.basketballModels.NbaEvent
import com.lucas.sportsdemo.api.basketballModels.League
import com.lucas.sportsdemo.api.basketballModels.SeasonXX

data class BasketballModel(
    val day: Day,
    val events: List<NbaEvent>,
    val leagues: List<League>,
    val season: SeasonXX
)