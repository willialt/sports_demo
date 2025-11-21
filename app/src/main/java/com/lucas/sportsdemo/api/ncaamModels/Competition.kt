package com.lucas.sportsdemo.api.ncaamModels

data class Competition(
    val attendance: Int,
    val broadcast: String,
    val broadcasts: List<Broadcast>,
    val competitors: List<Competitor>,
    val conferenceCompetition: Boolean,
    val date: String,
    val format: Format,
    val geoBroadcasts: List<GeoBroadcast>,
    val headlines: List<Headline>,
    val highlights: List<Highlight>,
    val id: String,
    val neutralSite: Boolean,
    val notes: List<Note>,
    val playByPlayAvailable: Boolean,
    val recent: Boolean,
    val startDate: String,
    val status: StatusX,
    val timeValid: Boolean,
    val tournamentId: Int,
    val type: TypeXX,
    val uid: String,
    val venue: VenueX
)