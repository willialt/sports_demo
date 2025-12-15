package com.lucas.sportsdemo.api.gameDetailModels

data class Broadcast(
    val isNational: Boolean,
    val lang: String,
    val market: Market,
    val media: Media,
    val region: String,
    val type: TypeXXX
)