package com.lucas.sportsdemo.api.models

data class League(
    val abbreviation: String,
    val calendar: List<Calendar>,
    val calendarEndDate: String,
    val calendarIsWhitelist: Boolean,
    val calendarStartDate: String,
    val calendarType: String,
    val id: String,
    val logos: List<LogoXX>,
    val midsizeName: String,
    val name: String,
    val season: SeasonX,
    val slug: String,
    val uid: String
)