package com.lucas.sportsdemo.api.extraModels

data class Provider(
    val displayName: String,
    val id: String,
    val logos: List<LogoX>,
    val name: String,
    val priority: Int
)