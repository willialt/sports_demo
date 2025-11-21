package com.lucas.sportsdemo.api.models

data class Moneyline(
    val away: Away,
    val displayName: String,
    val home: Home,
    val shortDisplayName: String
)