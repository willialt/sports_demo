package com.lucas.sportsdemo.api.gameDetailModels

data class Meta(
    val firstPlayWallClock: String,
    val gameState: String,
    val gameSwitcherEnabled: Boolean,
    val gp_topic: String,
    val lastPlayWallClock: String,
    val lastUpdatedAt: String,
    val picker_topic: String,
    val syncUrl: String
)