package com.lucas.sportsdemo.api.gameDetailModels

data class Official(
    val displayName: String,
    val fullName: String,
    val order: Int,
    val position: PositionX
)