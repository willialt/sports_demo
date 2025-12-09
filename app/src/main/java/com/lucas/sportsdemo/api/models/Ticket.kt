package com.lucas.sportsdemo.api.models

data class Ticket(
    val links: List<Link>,
    val numberAvailable: Int,
    val summary: String
)