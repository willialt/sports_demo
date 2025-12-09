package com.lucas.sportsdemo.api.extraModels

data class League(
    val abbreviation: String,
    val calendar: List<Calendar>,
    val calendarEndDate: String,
    val calendarIsWhitelist: Boolean,
    val calendarStartDate: String,
    val calendarType: String,
    val id: String,
    val logos: List<Logo>,
    val name: String,
    val season: SeasonX,
    val slug: String,
    val uid: String
)