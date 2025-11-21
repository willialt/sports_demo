package com.lucas.sportsdemo.api.ncaamModels

data class Headline(
    val description: String,
    val shortLinkText: String,
    val type: String,
    val video: List<Video>
)