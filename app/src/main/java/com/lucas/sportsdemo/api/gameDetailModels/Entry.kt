package com.lucas.sportsdemo.api.gameDetailModels

data class Entry(
    val id: String,
    val link: String,
    val logo: List<Logo>,
    val stats: List<Stat>,
    val team: String,
    val uid: String
)