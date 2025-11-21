package com.lucas.sportsdemo.api.models

data class AwayTeamOdds(
    val favorite: Boolean,
    val favoriteAtOpen: Boolean,
    val team: TeamXXXXX,
    val underdog: Boolean
)