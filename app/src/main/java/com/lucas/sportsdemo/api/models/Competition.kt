package com.lucas.sportsdemo.api.models

data class Competition(
    val attendance: Int,
    val broadcast: String,
    val broadcasts: List<Broadcast>,
    val competitors: List<Competitor>,
    val conferenceCompetition: Boolean,
    val date: String,
    val dateValid: Boolean,
    val format: Format,
    val geoBroadcasts: List<GeoBroadcast>,
    val groups: Groups,
    val highlights: List<Any?>,
    val id: String,
    val leaders: List<LeaderXX>,
    val neutralSite: Boolean,
    val notes: List<Any?>,
    val odds: List<Odd>,
    val playByPlayAvailable: Boolean,
    val recent: Boolean,
    val startDate: String,
    val status: StatusX,
    val tickets: List<Ticket>,
    val timeValid: Boolean,
    val type: TypeXX,
    val uid: String,
    val venue: VenueX
)