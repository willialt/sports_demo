package com.lucas.sportsdemo.api.basketballModels

data class LinkX(
    val href: String,
    val isExternal: Boolean,
    val isPremium: Boolean,
    val rel: List<String>,
    val text: String
)