package com.lucas.sportsdemo.api.models

data class LinkX(
    val href: String,
    val isExternal: Boolean,
    val isPremium: Boolean,
    val rel: List<String>,
    val text: String
)