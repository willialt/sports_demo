package com.lucas.sportsdemo.api.ncaamModels

data class cbbModel(
    val day: Day,
    val events: List<Event>,
    val eventsDate: EventsDate,
    val leagues: List<League>
)