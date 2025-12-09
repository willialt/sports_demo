package com.lucas.sportsdemo.api.models

data class Link(
    val href: String,
    val isExternal: Boolean,
    val isPremium: Boolean,
    val language: String,
    val rel: List<String>,
    val shortText: String,
    val text: String,
    val tracking: TrackingX
)