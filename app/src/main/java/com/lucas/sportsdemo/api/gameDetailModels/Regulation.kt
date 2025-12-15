package com.lucas.sportsdemo.api.gameDetailModels

data class Regulation(
    val clock: Double,
    val displayName: String,
    val periods: Int,
    val slug: String
)