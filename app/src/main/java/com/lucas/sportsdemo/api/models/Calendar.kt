package com.lucas.sportsdemo.api.models

data class Calendar(
    val endDate: String,
    val entries: List<Entry>,
    val label: String,
    val startDate: String,
    val value: String
)