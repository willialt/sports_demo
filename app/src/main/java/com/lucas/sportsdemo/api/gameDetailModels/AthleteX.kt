package com.lucas.sportsdemo.api.gameDetailModels

data class AthleteX(
    val displayName: String,
    val firstName: String,
    val guid: String,
    val headshot: Headshot,
    val id: String,
    val jersey: String,
    val lastName: String,
    val links: List<LinkX>,
    val uid: String
)