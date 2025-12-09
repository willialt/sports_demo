package com.lucas.sportsdemo.api.extraModels

data class Video(
    val deviceRestrictions: DeviceRestrictions,
    val duration: Int,
    val headline: String,
    val id: Int,
    val links: Links,
    val source: String,
    val thumbnail: String,
    val tracking: Tracking
)