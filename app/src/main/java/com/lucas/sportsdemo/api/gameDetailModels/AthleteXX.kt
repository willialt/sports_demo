package com.lucas.sportsdemo.api.gameDetailModels

data class AthleteXX(
    val collegeAthlete: CollegeAthlete,
    val displayName: String,
    val fullName: String,
    val guid: String,
    val headshot: Headshot,
    val id: String,
    val jersey: String,
    val lastName: String,
    val links: List<LinkX>,
    val position: Position,
    val shortName: String,
    val status: Status,
    val team: TeamXXXXX,
    val uid: String
)