package com.lucas.sportsdemo.api.models

data class Provider(
    val id: String,
    val logos: List<LogoX>,
    val name: String,
    val priority: Int
)