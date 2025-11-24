package com.lucas.sportsdemo

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
//import com.lucas.sportsdemo.api.BasketballModel
import com.lucas.sportsdemo.api.GameCardUiModel
import com.lucas.sportsdemo.api.NetworkResponse
import com.lucas.sportsdemo.api.RetrofitInstance
import com.lucas.sportsdemo.api.SportsModel
//import com.lucas.sportsdemo.api.mappers.GameMapper
import com.lucas.sportsdemo.api.models.Event
import kotlinx.coroutines.launch
import retrofit2.Response

class SportsViewModel : ViewModel(){

    private val sportsApi = RetrofitInstance.sportsApi
    private val _sportsResult = MutableLiveData<NetworkResponse<SportsModel>>()
    val sportsResult : LiveData<NetworkResponse<SportsModel>> = _sportsResult

    // NEW: Hold simplified game data for UI
    private val _gamesUiList = MutableLiveData<List<GameCardUiModel>>() // changed GameCardUiModel to Any to be safe for all sports
    val gamesUiList: LiveData<List<GameCardUiModel>> = _gamesUiList // same as above

    // new variables for parameters
    var defaultWeek: Int? = null
    var defaultYear : Int? = null
    var defaultSeasonType: Int? = null
    var currentLeague: String? = null


    fun getLeagueData(sport: String, lastWeek: Boolean) {
        currentLeague = sport // saves sport
        _sportsResult.value = NetworkResponse.Loading
        val (sportCategory, leaguePath) = when (sport) {
            "NCAAF" -> "football" to "college-football"
            "NFL" -> "football" to "nfl"
            "NBA" -> "basketball" to "nba"
            "NCAAM" -> "basketball" to "mens-college-basketball"
            else -> null to null
        }
        if (sportCategory == null || leaguePath == null) {
            _sportsResult.value = NetworkResponse.Error("No API for $sport")
            return
        }

        viewModelScope.launch {
            // Commenting out what had previously working for just football to be safe
            try {
                // FIX ME! call basketball API when NBA r
                val weekToLoad = if (lastWeek) defaultWeek?.minus(1) else defaultWeek

                val response = sportsApi.getFootballGames(
                    league = leaguePath,
                    year = defaultYear,
                    week = weekToLoad,
                    seasonType = defaultSeasonType
                )
                Log.i("test url","URL test: $sportCategory / $leaguePath -> ${response.raw().request.url}")
                if (response.isSuccessful) {
                    val model = response.body()
                    _sportsResult.value = NetworkResponse.Success(model!!)

                    // Save calendar values on default call
                    if (defaultWeek == null) {
                        defaultYear = model.season.year
                        defaultSeasonType = model.season.type
                        defaultWeek = model.week.number
                    }

                    // convert each event to GameCardUiModel
                    val events = model.events.orEmpty()
                    val uiModels = events.map { it.toUiModel() }
                    _gamesUiList.value = uiModels

                } else {
                    _sportsResult.value = NetworkResponse.Error("Failed to load data")
//                            Log.i("Error", response.message())
                }
            } catch (e: Exception) {
                _sportsResult.value = NetworkResponse.Error("Exception: ${e.message}")
//                        Log.i("Crash", "Exception: ${e.message}") // this logs
            }
        }
    }

    fun Event.toUiModel(): GameCardUiModel {
        val competition = competitions.firstOrNull()
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
            startTime = formatGameTime(competition?.date), // startTime = competition?.date,
            spread = competition?.odds?.firstOrNull()?.spread,
            team1Logo = home?.team?.logo,
            team2Logo = away?.team?.logo,
            team1Color = home?.team?.color,
            team2Color = away?.team?.color,
            broadcast = broadcast
        )
    }

//    fun toUiModel(): GameCardUiModel { // in process of making function usable for both basketball and football
//        val competition = competitions.firstOrNull()
//        val competitors = competition?.competitors.orEmpty()
//        val broadcast = competition?.broadcasts?.firstOrNull()?.names?.firstOrNull()
//        val away = competitors.getOrNull(0)
//        val home = competitors.getOrNull(1)
//        return GameCardUiModel(
//            team1 = home?.team?.shortDisplayName ?: "TBD",
//            team2 = away?.team?.shortDisplayName ?: "TBD",
//            team1Record = home?.records?.firstOrNull()?.summary,
//            team2Record = away?.records?.firstOrNull()?.summary,
//            team1Rank = home?.curatedRank?.current ?: 99,
//            team2Rank = away?.curatedRank?.current ?: 99,
//            team1Abr = home?.team?.abbreviation,
//            team2Abr = away?.team?.abbreviation,
//            startTime = formatGameTime(competition?.date),
////            startTime = competition?.date,
//            spread = competition?.odds?.firstOrNull()?.spread,
//            team1Logo = home?.team?.logo,
//            team2Logo = away?.team?.logo,
//            team1Color = home?.team?.color,
//            team2Color = away?.team?.color,
//            broadcast = broadcast
//        )
//    }

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