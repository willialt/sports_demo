package com.lucas.sportsdemo.api.extraModels

data class Headline(
    val description: String,
    val shortLinkText: String,
    val type: String,
    val video: List<Video>
)