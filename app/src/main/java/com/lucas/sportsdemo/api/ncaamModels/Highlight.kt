package com.lucas.sportsdemo.api.ncaamModels

data class Highlight(
    val ad: Ad,
    val cerebroId: String,
    val description: String,
    val deviceRestrictions: DeviceRestrictions,
    val duration: Int,
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