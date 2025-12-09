package com.lucas.sportsdemo.api.extraModels

data class Link(
    val href: String,
    val isExternal: Boolean,
    val isPremium: Boolean,
    val rel: List<String>,
    val text: String
)