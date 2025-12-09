package com.lucas.sportsdemo.api.extraModels

data class Status(
    val clock: Double,
    val displayClock: String,
    val isTBDFlex: Boolean,
    val period: Int,
    val type: TypeXX
)