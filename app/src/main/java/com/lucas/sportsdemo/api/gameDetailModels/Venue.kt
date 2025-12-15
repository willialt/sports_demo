package com.lucas.sportsdemo.api.gameDetailModels

data class Venue(
    val address: Address,
    val fullName: String,
    val grass: Boolean,
    val guid: String,
    val id: String,
    val images: List<Image>
)