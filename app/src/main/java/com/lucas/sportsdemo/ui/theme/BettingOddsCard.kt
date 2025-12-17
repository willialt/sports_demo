package com.lucas.sportsdemo.ui.theme

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.lucas.sportsdemo.api.GameDetailUiModel

@Composable
fun BettingOddsCard(
    game: GameDetailUiModel
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(6.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {

            Text(
                text = "Betting Odds",
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.padding(bottom = 12.dp)
            )

            // ---------- MONEYLINE ----------
            OddsRow(
                label = "Moneyline",
                leftTeam = game.team1,
                leftValue = formatOdds(game.homeMlOdds),
                rightTeam = game.team2,
                rightValue = formatOdds(game.awayMlOdds)
            )

            Spacer(modifier = Modifier.height(12.dp))

            // ---------- SPREAD ----------
            OddsRow(
                label = "Spread",
                leftTeam = game.team1,
                leftValue = formatSpread(game.spread, game.homeSpreadOdds),
                rightTeam = game.team2,
                rightValue = formatSpread(
                    game.spread?.let { -it },
                    game.awaySpreadOdds
                )
            )

            Spacer(modifier = Modifier.height(12.dp))

            // ---------- OVER / UNDER ----------
            OddsRow(
                label = "Total",
                leftTeam = "Over ${game.overUnder ?: "--"}",
                leftValue = formatOdds(game.overOdds),
                rightTeam = "Under ${game.overUnder ?: "--"}",
                rightValue = formatOdds(game.underOdds)
            )
        }
    }
}
@Composable
private fun OddsRow(
    label: String,
    leftTeam: String?,
    leftValue: String,
    rightTeam: String?,
    rightValue: String
) {
    Column {
        Text(
            text = label,
            style = MaterialTheme.typography.labelMedium,
            color = MaterialTheme.colorScheme.secondary
        )

        Spacer(modifier = Modifier.height(6.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            OddsBox(
                title = leftTeam,
                value = leftValue,
                modifier = Modifier.weight(1f)
            )

            Spacer(modifier = Modifier.width(12.dp))

            OddsBox(
                title = rightTeam,
                value = rightValue,
                modifier = Modifier.weight(1f)
            )
        }
    }
}
@Composable
private fun OddsBox(
    title: String?,
    value: String,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier,
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant
        )
    ) {
        Column(
            modifier = Modifier.padding(vertical = 10.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            if (title != null) {
                Text(
                    text = title,
                    style = MaterialTheme.typography.bodySmall
                )
            }

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = value,
                style = MaterialTheme.typography.titleSmall,
                fontWeight = FontWeight.Bold
            )
        }
    }
}
private fun formatOdds(value: Double?): String {
    return value?.let {
        if (it > 0) "+${it.toInt()}" else it.toInt().toString()
    } ?: "--"
}

private fun formatSpread(spread: Double?, odds: Double?): String {
    val spreadText = spread?.let {
        if (it > 0) "+$it" else it.toString()
    } ?: "--"

    val oddsText = formatOdds(odds)
    return "$spreadText ($oddsText)"
}
