package com.lucas.sportsdemo.api.basketballModels

data class GeoBroadcast(
    val lang: String,
    val market: Market,
    val media: Media,
    val region: String,
    val type: Type
)