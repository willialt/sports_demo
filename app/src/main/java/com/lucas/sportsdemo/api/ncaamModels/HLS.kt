package com.lucas.sportsdemo.api.ncaamModels

data class HLS(
    val `9x16`: X16,
    val HD: HD,
    val cmaf: Cmaf,
    val href: String,
    val shield: Shield
)