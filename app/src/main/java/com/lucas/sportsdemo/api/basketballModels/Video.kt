package com.lucas.sportsdemo.api.basketballModels

data class Video(
    val deviceRestrictions: DeviceRestrictions,
    val duration: Int,
    val geoRestrictions: GeoRestrictions,
    val headline: String,
    val id: Int,
    val links: Links,
    val source: String,
    val thumbnail: String,
    val tracking: Tracking
)