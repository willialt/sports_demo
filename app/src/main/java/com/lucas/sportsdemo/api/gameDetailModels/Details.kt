package com.lucas.sportsdemo.api.gameDetailModels

data class Details(
    val detail: String,
    val fantasyStatus: FantasyStatus,
    val location: String,
    val returnDate: String,
    val side: String,
    val type: String
)