package com.lucas.sportsdemo.api

data class GameDetailUiModel(
    val team1: String?,
    val team2: String?,
    val team1Id: String?,
    val team2Id: String?,
    val team1Short:  String?,
    val team2Short: String?,
    val team1Record: String?,
    val team2Record: String?,
    val team1Rank: Int?,
    val team2Rank: Int?,
    val team1Abr: String?,
    val team2Abr: String?,
    val startTime: String?,
    val homePregameWinProb: String?,
    val awayPregameWinProb: String?,
    val spread: Double?,
    val team1Logo: String?,
    val team2Logo: String?,
    val team1Color: String?,
    val team2Color: String?,
    val broadcast: String? = null,
    val status: GameStatus,
    val homeScore:  String?,
    val awayScore: String?,
    val homeWinner: Boolean?,
    val awayWinner: Boolean?,
    val displayClock: String?,
    val period: Int?,
    val shortDetail: String?,
    val shortDownDistanceText: String?,
    val homeSpreadOdds: Double?,
    val awaySpreadOdds: Double?,
    val homeMlOdds: Double?,
    val awayMlOdds: Double?,
    val overUnder: Double?,
    val overOdds: Double?,
    val underOdds: Double?,
    val id: String?,
    val homePossession: Boolean?,
    val awayPossession: Boolean?,
    val yardLineText: String?,
    val yardsToEndzone: Int?,
    val playSummary: String?,
//    val awayStat0: String?, // points per game
//    val awayStat1: String?, // yards per game
//    val awayStat4: String?,  // points per game allowed
//    val awayStat5: String?, // yards per game allowed
//    val homeStat0: String?, // points per game
//    val homeStat1: String?, // yards per game
//    val homeStat4: String?,  // points per game allowed
//    val homeStat5: String? // yards per game allowed
//    val boxscoreTestDouble: Double?


)
