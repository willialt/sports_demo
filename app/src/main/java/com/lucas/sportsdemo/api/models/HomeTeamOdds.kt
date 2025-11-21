package com.lucas.sportsdemo.api.models

data class HomeTeamOdds(
    val favorite: Boolean,
    val favoriteAtOpen: Boolean,
    val team: TeamXXXXX,
    val underdog: Boolean
)