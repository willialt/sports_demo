package com.lucas.sportsdemo.ui.theme

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.lucas.sportsdemo.api.GameCardUiModel
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.core.graphics.toColorInt
import com.lucas.sportsdemo.api.GameStatus
import com.lucas.sportsdemo.R



@Composable
fun GameCard(game: GameCardUiModel) {
    val team1Color = parseTeamColor(game.team1Color)
    val team2Color = parseTeamColor(game.team2Color)

    // from the event extract the teams, logos, records, start time, and spread
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 6.dp, horizontal = 12.dp),
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp)
        ) {
            // Teams & Record row
            Box(
                modifier = Modifier.fillMaxWidth()
            ) {
                // left team 2 (away)
                Row(
                    modifier = Modifier.align(Alignment.CenterStart),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    if (game.team2Logo != null) {
                        Image(
                            painter = rememberAsyncImagePainter(game.team2Logo),
                            contentDescription = "${game.team2} logo",
                            modifier = Modifier.size(48.dp),
                            contentScale = ContentScale.Fit
                        )
                    }
                    Spacer(modifier = Modifier.width(8.dp))

                    Column(horizontalAlignment = Alignment.Start) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            if (game.team2Rank != null && game.team2Rank in 1..25) {
                                Text(
                                    text = "${game.team2Rank}",
                                    color = Color.Gray,
                                    fontSize = 14.sp,
                                    fontWeight = FontWeight.SemiBold,
                                    modifier = Modifier.padding(end = 4.dp)
                                )
                            }
                            Text(text = game.team2, fontWeight = FontWeight.Bold, fontSize = 18.sp)
                        }
//                        Text(text = game.team1, fontWeight = FontWeight.Bold, fontSize = 18.sp)
                        Text(text = game.team2Record ?: "", fontSize = 14.sp)
                    }
                }

                // If Final state, Middle shows scores, Final, no odds or network.
                when (game.status) {
                    GameStatus.UPCOMING -> {
                        // === Upcoming Game Middle column (Time + Spread + Broadcast) ===
                        Column(
                            modifier = Modifier.align(Alignment.Center),
                            horizontalAlignment = Alignment.CenterHorizontally
//                      verticalArrangement = Arrangement.Center
                        ) {
                            if (!game.broadcast.isNullOrBlank()) {
                                Text(
                                    text = game.broadcast,
                                    fontSize = 12.sp,
                                    color = Color.Gray
                                )
                            }
                            Text(
                                text = game.startTime ?: "TBD",
                                fontWeight = FontWeight.SemiBold,
                                fontSize = 16.sp
                            )
                            Text(
                                text = "${game.team1Abr} ${game.spread?.formatSpread() ?: "N/A"}",
                                fontSize = 13.sp,
                                color = Color.Gray
                            )

                        }
                    }
                    GameStatus.LIVE -> {
                        // Live scores
                        Row(
                            modifier = Modifier
                                .align(Alignment.Center)
                                .fillMaxWidth(0.45f), // keeps the 3 blocks compact and centered
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            val awayScoreInt = game.awayScore?.toIntOrNull() ?: 0
                            val homeScoreInt = game.homeScore?.toIntOrNull() ?: 0
                            // === LEFT SCORE ===
                            Box(
                                modifier = Modifier.width(60.dp),  // fixed width
                                contentAlignment = Alignment.Center
                            ) {
                                Text(
                                    text = game.awayScore ?: "-",
                                    fontWeight = if (awayScoreInt > homeScoreInt) FontWeight.Bold else FontWeight.Normal,
                                    color = if (awayScoreInt > homeScoreInt) Color.Black else Color.Gray,
                                    fontSize = 42.sp
                                )
                            }

                            // Add place for possession icon here if game.possession == game.team2Id
//                            PossessionIcon(isVisible = game.possession == game.team2Id)
                            FixedPossessionSlot(show = game.possession == game.team2Id)

                            // === LIVE ===
                            Box(
                                modifier = Modifier.width(110.dp),   // fixed width
                                contentAlignment = Alignment.Center
                            ) {
                                //  Middle Column with Clock, quarter
                                Column(
                                    modifier = Modifier.align(Alignment.Center),
                                    horizontalAlignment = Alignment.CenterHorizontally
                                ) {
                                    // Down and Distance
                                    Text(
                                        text = game.shortDownDistanceText ?: "---",
                                        fontWeight = FontWeight.SemiBold,
                                        fontSize = 16.sp
                                    )
                                    // Time and Quarter
                                    Text(
                                        text = "${game.shortDetail}",
                                        fontWeight = FontWeight.Bold,
                                        fontSize = 18.sp
                                    )

                                    // Yard line
                                    Text(
                                        text = game.possessionText ?: "---",
                                        fontWeight = FontWeight.SemiBold,
                                        fontSize = 16.sp
                                    )
                                }
                            }

                            // Add place for possession icon here if game.possession == game.team1Id
//                            PossessionIcon(isVisible = game.possession == game.team1Id)
                            FixedPossessionSlot(show = game.possession == game.team1Id)

                            // === RIGHT SCORE ===
                            Box(
                                modifier = Modifier.width(60.dp),   // fixed width
                                contentAlignment = Alignment.Center
                            ) {
                                Text(
                                    text = game.homeScore ?: "-",
                                    fontWeight = if (awayScoreInt < homeScoreInt) FontWeight.Bold else FontWeight.Normal,
                                    color = if (awayScoreInt < homeScoreInt) Color.Black else Color.Gray,
                                    fontSize = 42.sp
                                )
                            }
                        }
                    }
                    GameStatus.FINAL -> {
                        Row(
                            modifier = Modifier
                                .align(Alignment.Center)
                                .fillMaxWidth(0.45f), // keeps the 3 blocks compact and centered
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            // === LEFT SCORE ===
                            Box(
                                modifier = Modifier.width(80.dp),  // fixed width
                                contentAlignment = Alignment.Center
                            ) {
                                Text(
                                    text = game.awayScore ?: "-",
                                    fontWeight = if (game.awayWinner == true) FontWeight.Bold else FontWeight.Normal,
                                    color = if (game.awayWinner == true) Color.Black else Color.Gray,
                                    fontSize = 42.sp
                                )
                            }

                            // === FINAL ===
                            Box(
                                modifier = Modifier.width(60.dp),   // fixed width
                                contentAlignment = Alignment.Center
                            ) {
                                Text(
                                    text = "Final",
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 18.sp
                                )
                            }

                            // === RIGHT SCORE ===
                            Box(
                                modifier = Modifier.width(80.dp),   // fixed width
                                contentAlignment = Alignment.Center
                            ) {
                                Text(
                                    text = game.homeScore ?: "-",
                                    fontWeight = if (game.homeWinner == true) FontWeight.Bold else FontWeight.Normal,
                                    color = if (game.homeWinner == true) Color.Black else Color.Gray,
                                    fontSize = 42.sp
                                )
                            }
                        }

                    }
                }



                // Right team 1 (home)
                Row(modifier = Modifier.align(Alignment.CenterEnd),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column(horizontalAlignment = Alignment.End) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            if (game.team1Rank != null && game.team1Rank in 1..25) {
                                Text(
                                    text = "${game.team1Rank}",
                                    color = Color.Gray,
                                    fontSize = 14.sp,
                                    fontWeight = FontWeight.SemiBold,
                                    modifier = Modifier.padding(end = 4.dp)
                                )
                            }
                            Text(
                                text = game.team1,
                                fontWeight = FontWeight.Bold,
                                fontSize = 18.sp
                            )
                        }
                        Text(text = game.team1Record ?: "", fontSize = 14.sp)
                    }
                    Spacer(modifier = Modifier.width(8.dp))
                    if (game.team1Logo != null) {
                        Image(
                            painter = rememberAsyncImagePainter(game.team1Logo),
                            contentDescription = "${game.team1} logo",
                            modifier = Modifier.size(48.dp),
                            contentScale = ContentScale.Fit
                        )
                    }
                }
            }

            // Color bar
            Spacer(modifier = Modifier.height(10.dp))
            Row(modifier = Modifier
                .fillMaxWidth()
                .height(8.dp)
                .clip(RoundedCornerShape(bottomStart = 12.dp, bottomEnd = 12.dp))
            ) {

                Box(
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxHeight()
//                        .clip(RoundedCornerShape(bottomStart = 12.dp))
                        .background(team2Color)
                )  // this color doesn't appear either
                Box(
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxHeight()
//                        .clip(RoundedCornerShape(bottomEnd = 12.dp))
                        .background(team1Color)

                )
            }

//            Spacer(modifier = Modifier.height(8.dp))

//            // Game details row
//            Row(
//                modifier = Modifier.fillMaxWidth(),
//                horizontalArrangement = Arrangement.SpaceBetween
//            ) {
//                Text(text = game.startTime ?: "TBD")
//                Text(text = "${game.team2Abr} ${game.spread?.toString() ?: "N/A"}")
//            }
        }
    }

}

@Composable
fun PossessionIcon(isVisible: Boolean) {
    if (!isVisible) return

    Image(
        painter = painterResource(id = R.drawable.football_icon),
        contentDescription = "Possession",
        modifier = Modifier
            .size(60.dp)
            .padding(horizontal = 2.dp),
        contentScale = ContentScale.Fit
    )
}

@Composable
fun FixedPossessionSlot(show: Boolean) {
    Box(
        modifier = Modifier.width(38.dp),    // ⬅ consistent space even when empty
        contentAlignment = Alignment.Center
    ) {
        if (show) {
            Image(
                painter = painterResource(id = R.drawable.football_icon),
                contentDescription = "Possession",
                modifier = Modifier.size(38.dp),
                contentScale = ContentScale.Fit
            )
        }
    }
}


private fun parseTeamColor(hex: String?): Color {
    return try {
        if (hex.isNullOrEmpty()) Color.Gray
        else Color("#$hex".toColorInt())
    } catch (e: Exception) {
        Color.Gray
    }
}


private fun Double?.formatSpread(): String {
    return this?.let {
        if (it >= 0) "+$it" else "$it"
    } ?: "N/A"
}

@Preview(showBackground = true)
@Composable
fun GameCardPreview() {
    SportsDemoTheme {
        GameCard(
            game = GameCardUiModel(
                team1 = "USC",
                team2 = "Northwestern",
                team1Id = "24",
                team2Id = "21",
                team1Record = "7–2",
                team2Record = "8–1",
                team1Rank = 20,
                team2Rank = 99,
                startTime = "Fri 8:00 PM ET",
                team1Abr = "USC",
                team2Abr = "NU",
                spread = -3.5,
                team1Logo = "https://a.espncdn.com/i/teamlogos/ncaa/500/30.png",
                team2Logo = "https://a.espncdn.com/i/teamlogos/nfl/500/scoreboard/den.png",
                team1Color = "9e2237",
                team2Color = "582c83",
                broadcast = "FOX",
                status = GameStatus.LIVE, // add team scores and winner
                homeScore = "17",
                awayScore = "13",
                homeWinner = false,
                awayWinner = false,
                displayClock = "1:31",
                period = 3,
                shortDetail = "1:33 - 4th",
                // Live variables
                possession = "24",
                possessionText = "PHI 34",
                shortDownDistanceText = "3rd and 10",
            )
        )
    }
}