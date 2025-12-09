package com.lucas.sportsdemo.api.extraModels

import com.lucas.sportsdemo.api.models.Situation

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
    val leaders: List<Leader>,
    val neutralSite: Boolean,
    val notes: List<Any?>,
    val playByPlayAvailable: Boolean,
    val recent: Boolean,
    val situation: Situation,
    val startDate: String,
    val status: Status,
    val timeValid: Boolean,
    val type: TypeXXX,
    val uid: String,
    val venue: VenueX
)