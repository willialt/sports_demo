package com.lucas.sportsdemo.api.gameDetailModels

data class Statistic(
    val athletes: List<Athlete>,
    val descriptions: List<String>,
    val keys: List<String>,
    val labels: List<String>,
    val name: String,
    val text: String,
    val totals: List<String>
)