package com.lucas.sportsdemo.api.ncaamModels

data class GeoBroadcast(
    val lang: String,
    val market: Market,
    val media: Media,
    val region: String,
    val type: Type
)