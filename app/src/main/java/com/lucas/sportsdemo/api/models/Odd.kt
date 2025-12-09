package com.lucas.sportsdemo.api.models

data class Odd(
    val awayTeamOdds: AwayTeamOdds,
    val details: String,
    val header: Header,
    val homeTeamOdds: HomeTeamOdds,
    val link: Link,
    val moneyline: Moneyline,
    val overUnder: Double,
    val pointSpread: PointSpread,
    val provider: Provider,
    val spread: Double,
    val total: Total
)