package com.lucas.sportsdemo.api.gameDetailModels

data class Competition(
//    val boxscoreAvailable: Boolean,
//    val boxscoreMinutes: Boolean,
//    val boxscoreSource: String,
    val broadcasts: List<Broadcast>,
//    val commentaryAvailable: Boolean,
    val competitors: List<Competitor>,
//    val conferenceCompetition: Boolean,
    val date: String,
    val id: String,
//    val liveAvailable: Boolean,
//    val neutralSite: Boolean,
//    val onWatchESPN: Boolean,
//    val playByPlaySource: String,
//    val recent: Boolean,
    val status: StatusXX
//    val uid: String
//    val wallclockAvailable: Boolean
)