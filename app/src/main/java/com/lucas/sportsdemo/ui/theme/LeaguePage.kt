package com.lucas.sportsdemo.ui.theme

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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.lucas.sportsdemo.SportsViewModel
import com.lucas.sportsdemo.api.NetworkResponse
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.LaunchedEffect


@Composable
fun LeaguePage(viewModel: SportsViewModel) {

    val sportsResult = viewModel.sportsResult.observeAsState()
    val gamesUiList = viewModel.gamesUiList.observeAsState(emptyList())
    var showLastWeek by remember { mutableStateOf(false) }

    LaunchedEffect(viewModel.currentLeague) {
        showLastWeek = false
    }


    Row(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF5F5F5))
            .padding(top = 24.dp)
    ) {
        // ==== Left Menu ====
        Card (
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth(0.15f) // ~15% of screen width
                .padding(8.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
        ){
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(vertical = 16.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                val leagues = listOf("NCAAF", "NFL", "NBA", "NCAAM")
                leagues.forEach { league ->
                    Button(
                        onClick = {
                        // later -> trigger API call for this league
                         viewModel.getLeagueData(sport = league, lastWeek = false)
                        },
                        modifier = Modifier
                            .fillMaxWidth(0.9f)
                            .height(48.dp)
                    ) {
                        Text(
                            text = league,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }

            }
        }

        // Show content or loading
        when(val result = sportsResult.value) {
            is NetworkResponse.Error -> {
                Text(text = result.message)
            }
            NetworkResponse.Loading -> {
                CircularProgressIndicator()
            }
            is NetworkResponse.Success<*> -> {
                // Print the game cards for each event...
                if (gamesUiList.value.isEmpty()) {
                    Text("No Games available")
                } else {
                    // ==== Right Main content area (Tabs and Games) ====
                    Column(
                        modifier = Modifier
                            .fillMaxHeight()
                            .weight(1f)
                            .padding(16.dp),
                        verticalArrangement = Arrangement.Top,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        // Add row here with buttons for "Parley Builder", "Last Week", "This Week", and drop down Menu
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .background(Color(0xFFF5F5F5))
                                .padding(top = 24.dp),
                            horizontalArrangement = Arrangement.Center
                        ) {


                            WeekTabs(
                                selected = showLastWeek,
                                onSelect = { isLastWeek ->
                                    showLastWeek = isLastWeek

                                    val sport = viewModel.currentLeague ?: return@WeekTabs
                                    viewModel.getLeagueData(
                                        sport = sport,
                                        lastWeek = isLastWeek
                                    )
                                }
                            )

                            // If on college football, Drop down menu with college conferences...
                            // add later
                        }
                        LazyColumn {
                            items(gamesUiList.value) { game ->
                                GameCard(game = game)
                            }
                        }
                    }
                }
            }
            null -> Unit
        }
    }
}
