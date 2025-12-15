package com.lucas.sportsdemo.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.rememberAsyncImagePainter
import com.lucas.sportsdemo.SportsViewModel
import com.lucas.sportsdemo.api.GameCardUiModel
import com.lucas.sportsdemo.api.GameDetailUiModel
import com.lucas.sportsdemo.api.GameStatus
import com.lucas.sportsdemo.api.NetworkResponse


@Composable
fun GameDetailScreen(
    sport: String,
    league: String,
    gameId: String,
    viewModel: SportsViewModel = viewModel(),
    onBack: () -> Unit
) {
    LaunchedEffect(gameId) {
        viewModel.loadGameDetail(sport, league, gameId)
    }

    val gameDetail = viewModel.gameDetail.collectAsState()

    Column(modifier = Modifier.fillMaxSize()) {

        Button(onClick = onBack) {
            Text("Back")
        }

        when (val detail = gameDetail.value) {
            is NetworkResponse.Loading -> {
                Text("Loading...")
            }
            is NetworkResponse.Error -> {
                Text("Error: ${detail.message}")
            }
            is NetworkResponse.Success -> {
                GameDetailContent(detail.data)
//                GameDetailContent()
            }
        }
    }
}

@Composable
fun GameDetailContent(game: GameDetailUiModel) {
    Text("Game Screen")
    Column(modifier = Modifier.padding(16.dp)) {
        Text("${game.team2} @ ${game.team1}", fontSize = 22.sp)
        Spacer(Modifier.height(8.dp))

        Text("Score: ${game.awayScore} - ${game.homeScore}")
        Text("Status: ${game.status}")
        Text("Clock: ${game.displayClock ?: "--"}")
        Text("Period: ${game.period ?: "-"}")

        Spacer(Modifier.height(12.dp))

        if (game.status == GameStatus.LIVE) {
            Text("Down & Distance: ${game.shortDownDistanceText ?: "---"}")
            Text("Yard Line: ${game.yardLineText ?: "---"}")
            Text("Last Play: ${game.playSummary ?: "---"}")
        }
    }
}


//@Preview(showBackground = true)
//@Composable
//fun GameDetailScreenPreview() {
//    SportsDemoTheme {
//        GameCard(
//            game = GameCardUiModel(
//                team1 = "USC",
//                team2 = "Northwestern",
//                team1Id = "24",
//                team2Id = "21",
//                team1Record = "7–2",
//                team2Record = "8–1",
//                team1Rank = 20,
//                team2Rank = 99,
//                startTime = "Fri 8:00 PM ET",
//                team1Abr = "USC",
//                team2Abr = "NU",
//                spread = -3.5,
//                team1Logo = "https://a.espncdn.com/i/teamlogos/ncaa/500/30.png",
//                team2Logo = "https://a.espncdn.com/i/teamlogos/nfl/500/scoreboard/den.png",
//                team1Color = "9e2237",
//                team2Color = "582c83",
//                broadcast = "FOX",
//                status = GameStatus.LIVE, // add team scores and winner
//                homeScore = "17",
//                awayScore = "13",
//                homeWinner = false,
//                awayWinner = false,
//                displayClock = "1:31",
//                period = 3,
//                shortDetail = "1:33 - 4th",
//                // Live variables
//                possession = "24",
//                possessionText = "PHI 34",
//                shortDownDistanceText = "3rd and 10",
//            )
//        )
//    }
//}
