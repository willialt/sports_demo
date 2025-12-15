package com.lucas.sportsdemo.api.gameDetailModels

data class Overtime(
    val clock: Double,
    val displayName: String,
    val periods: Int,
    val slug: String
)