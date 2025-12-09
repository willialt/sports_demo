package com.lucas.sportsdemo.api.extraModels

data class Logo(
    val alt: String,
    val height: Int,
    val href: String,
    val lastUpdated: String,
    val rel: List<String>,
    val width: Int
)