package com.lucas.sportsdemo.api.gameDetailModels

data class Penalty(
    val status: StatusX,
    val type: TypeX,
    val yards: Int
)