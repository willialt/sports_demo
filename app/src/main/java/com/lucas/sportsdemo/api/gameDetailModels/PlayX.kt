package com.lucas.sportsdemo.api.gameDetailModels

data class PlayX(
    val awayScore: Int,
    val clock: Clock,
    val end: End,
    val homeScore: Int,
    val id: String,
    val modified: String,
    val penalty: Penalty,
    val period: Period,
    val pointAfterAttempt: PointAfterAttempt,
    val priority: Boolean,
    val scoringPlay: Boolean,
    val scoringType: ScoringType,
    val sequenceNumber: String,
    val start: Start,
    val statYardage: Int,
    val teamParticipants: List<TeamParticipant>,
    val text: String,
    val type: Type,
    val wallclock: String,
    val yardsAfterCatch: Int
)