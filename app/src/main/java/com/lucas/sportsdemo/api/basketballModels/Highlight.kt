package com.lucas.sportsdemo.api.basketballModels

data class Highlight(
    val ad: Ad,
    val cerebroId: String,
    val description: String,
    val deviceRestrictions: DeviceRestrictions,
    val duration: Int,
    val geoRestrictions: GeoRestrictions,
    val headline: String,
    val id: Int,
    val lastModified: String,
    val links: Links,
    val originalPublishDate: String,
    val source: String,
    val thumbnail: String,
    val timeRestrictions: TimeRestrictions,
    val tracking: Tracking
)