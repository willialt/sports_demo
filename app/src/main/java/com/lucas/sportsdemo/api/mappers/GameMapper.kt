package com.lucas.sportsdemo.api.mappers

import com.lucas.sportsdemo.api.models.Event as FootballEvent
import com.lucas.sportsdemo.api.basketballModels.Event as BasketballEvent
import com.lucas.sportsdemo.api.GameCardUiModel

object GameMapper {

    fun fromFootball(event: FootballEvent): GameCardUiModel {
        val competition = event.competitions.firstOrNull()
        val competitors = competition?.competitors.orEmpty()
        val broadcast = competition?.broadcasts?.firstOrNull()?.names?.firstOrNull()
        val away = competitors.getOrNull(0)
        val home = competitors.getOrNull(1)

        return GameCardUiModel(
            team1 = home?.team?.shortDisplayName ?: "TBD",
            team2 = away?.team?.shortDisplayName ?: "TBD",
            team1Record = home?.records?.firstOrNull()?.summary,
            team2Record = away?.records?.firstOrNull()?.summary,
            team1Rank = home?.curatedRank?.current ?: 99,
            team2Rank = away?.curatedRank?.current ?: 99,
            team1Abr = home?.team?.abbreviation,
            team2Abr = away?.team?.abbreviation,
            startTime = formatGameTime(competition?.date),
            spread = competition?.odds?.firstOrNull()?.spread,
            team1Logo = home?.team?.logo,
            team2Logo = away?.team?.logo,
            team1Color = home?.team?.color,
            team2Color = away?.team?.color,
            broadcast = broadcast
        )
    }

    fun fromBasketball(event: BasketballEvent): GameCardUiModel {
        // Basketball structure is 98% identical, so reuse the same logic.
        val competition = event.competitions.firstOrNull()
        val competitors = competition?.competitors.orEmpty()
        val broadcast = competition?.broadcasts?.firstOrNull()?.names?.firstOrNull()
        val away = competitors.getOrNull(0)
        val home = competitors.getOrNull(1)

        return GameCardUiModel(
            team1 = home?.team?.shortDisplayName ?: "TBD",
            team2 = away?.team?.shortDisplayName ?: "TBD",
            team1Record = home?.records?.firstOrNull()?.summary,
            team2Record = away?.records?.firstOrNull()?.summary,
            team1Rank = home?.curatedRank?.current ?: 99,
            team2Rank = away?.curatedRank?.current ?: 99,
            team1Abr = home?.team?.abbreviation,
            team2Abr = away?.team?.abbreviation,
            startTime = formatGameTime(competition?.date),
            spread = 99.9, // competition?.odds?.firstOrNull()?.spread,
            team1Logo = home?.team?.logo,
            team2Logo = away?.team?.logo,
            team1Color = home?.team?.color,
            team2Color = away?.team?.color,
            broadcast = "The Onion"// broadcast
        )
    }
    private fun formatGameTime(rawDate: String?): String? {
        if (rawDate.isNullOrBlank()) return null

        return try {
            // Some ESPN timestamps come like "2025-11-07T01:15Z" (missing :00 seconds)
            val normalized = if (rawDate.matches(Regex(".*T\\d{2}:\\d{2}Z$"))) {
                rawDate.replace("Z", ":00Z")
            } else rawDate

            val instant = java.time.Instant.parse(normalized)
            val formatter = java.time.format.DateTimeFormatter
                .ofPattern("EEE h:mm a")
                .withZone(java.time.ZoneId.systemDefault())

            formatter.format(instant)
        } catch (e: Exception) {
            e.printStackTrace() // Optional for debugging
            null
        }
    }
}