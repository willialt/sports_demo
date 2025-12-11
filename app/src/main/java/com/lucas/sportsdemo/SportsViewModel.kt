package com.lucas.sportsdemo

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
//import com.lucas.sportsdemo.api.BasketballModel
import com.lucas.sportsdemo.api.GameCardUiModel
import com.lucas.sportsdemo.api.GameStatus
import com.lucas.sportsdemo.api.NetworkResponse
import com.lucas.sportsdemo.api.RetrofitInstance
import com.lucas.sportsdemo.api.SportsModel
//import com.lucas.sportsdemo.api.mappers.GameMapper
import com.lucas.sportsdemo.api.models.Event
import com.lucas.sportsdemo.api.basketballModels.NbaEvent
import kotlinx.coroutines.launch
import retrofit2.Response
// debug imports
import android.content.Context
import com.google.gson.Gson
import com.lucas.sportsdemo.util.loadJsonFromAssets
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import java.time.LocalDate


class SportsViewModel : ViewModel(){

    private val sportsApi = RetrofitInstance.sportsApi
    private val _sportsResult = MutableLiveData<NetworkResponse<Any>>() // changed SportsModel to Any
    val sportsResult : LiveData<NetworkResponse<Any>> = _sportsResult

    // NEW: Hold simplified game data for UI
    private val _gamesUiList = MutableLiveData<List<GameCardUiModel>>() // changed GameCardUiModel to Any to be safe for all sports
    val gamesUiList: LiveData<List<GameCardUiModel>> = _gamesUiList // same as above

    // new variables for parameters
    var defaultWeek: Int? = null
    var defaultDay: String? = null
    private val _selectedDate = MutableStateFlow(LocalDate.now()) // dates for basketball
    val selectedDate = _selectedDate.asStateFlow()

    var defaultYear : Int? = null
    var defaultSeasonType: Int? = null
    var currentLeague: String? = null


    fun getLeagueData(sport: String, showPrevious: Boolean) {
        // Reset defaults whenever user selects a new league
        if (currentLeague != sport) {
            defaultWeek = null
            defaultYear = null
            defaultSeasonType = null
        }


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
//                val raw = sportsApi.getRawJson("basketball", "nba")

//                val json = raw.body()?.string()
//                Log.i("NBA_RAW", json ?: "NULL_JSON")
                if (sportCategory == "basketball") {
                    val dayToLoad: String = if (showPrevious){
                        // change string to prev day "2025-12-07" -> "2025-12-06"
                        _selectedDate.value.minusDays(1).toString().replace("-", "")
                    } else {
                        _selectedDate.value.toString().replace("-", "")
                    }

                    Log.i("default day", dayToLoad) // logs 20251211 and 20251210 for clicking on today and yesterday tabs but only today's games appear?

                    val response = sportsApi.getBasketballGames("basketball", leaguePath, dayToLoad)
                    Log.i(
                        "test url",
                        "URL test: $sportCategory / $leaguePath -> ${response.raw().request.url}"
                    ) // the url test incorrectly prints the scoreboard link with no query parameter attached...
                    if (response.isSuccessful) {
                        val model = response.body()
                        _sportsResult.value = NetworkResponse.Success(model!!) // Error here

                        // convert each event to GameCardUiModel
                        val events = model.events.orEmpty()
                        val uiModels = events.map { it.toUiModel() }
                        _gamesUiList.value = uiModels

                    } else {
                        _sportsResult.value = NetworkResponse.Error("Failed to load data")
                    }
                }

                // football stuff ---
                if (sportCategory == "football") {
                    val weekToLoad = if (showPrevious) defaultWeek?.minus(1) else defaultWeek

                    val response = sportsApi.getFootballGames(
                        league = leaguePath,
                        year = defaultYear,
                        week = weekToLoad,
                        seasonType = defaultSeasonType
                    )

                    Log.i(
                        "test url",
                        "URL test: $sportCategory / $leaguePath -> ${response.raw().request.url}"
                    )
                    if (response.isSuccessful) {
                        val model = response.body()
                        _sportsResult.value = NetworkResponse.Success(model!!)

                        // if there's no default week (first call or league change), set current.
                        if (defaultWeek == null) {
                            defaultYear = model.season.year
                            defaultSeasonType = model.season.type
                            defaultWeek = model.week.number
                        }
                        Log.i("default week", "$defaultWeek")

                        // convert each event to GameCardUiModel
                        val events = model.events.orEmpty()
                        val uiModels = events.map { it.toUiModel() }
                        _gamesUiList.value = uiModels

                    } else {
                        _sportsResult.value = NetworkResponse.Error("Failed to load data")
                        //                            Log.i("Error", response.message())
                    }
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
        val away = competitors.getOrNull(1)
        val home = competitors.getOrNull(0)
        val team1Id = home?.id
        val team2Id = away?.id
        val period = competition?.status?.period
        val displayClock = competition?.status?.displayClock
        val shortDetail = competition?.status?.type?.shortDetail
        val situation = competition?.situation
        val status = when(competition?.status?.type?.state) {
            "pre" -> GameStatus.UPCOMING
            "in" -> GameStatus.LIVE
            "post" -> GameStatus.FINAL
            else -> GameStatus.UPCOMING
        }
        return GameCardUiModel(
            // General Teams Info
            team1 = home?.team?.shortDisplayName ?: "TBD",
            team1Id = team1Id,
            team2 = away?.team?.shortDisplayName ?: "TBD",
            team2Id = team2Id,
            team1Record = home?.records?.firstOrNull()?.summary,
            team2Record = away?.records?.firstOrNull()?.summary,
            team1Rank = home?.curatedRank?.current ?: 99,
            team2Rank = away?.curatedRank?.current ?: 99,
            team1Abr = home?.team?.abbreviation,
            team2Abr = away?.team?.abbreviation,
            team1Logo = home?.team?.logo,
            team2Logo = away?.team?.logo,
            team1Color = home?.team?.color,
            team2Color = away?.team?.color,
            status = status,
            // Pregame Info
            startTime = formatGameTime(competition?.date), // startTime = competition?.date,
            spread = competition?.odds?.firstOrNull()?.spread,
            broadcast = broadcast,
            // Live Game Info
            homeScore = home?.score,
            awayScore = away?.score,
            displayClock = displayClock,
            period = period,
            shortDetail = shortDetail,
            possession = situation?.possession,
            shortDownDistanceText = situation?.shortDownDistanceText,
            possessionText = situation?.possessionText,

            // Post game Info
            homeWinner = home?.winner,
            awayWinner = away?.winner
        )
    }
    fun NbaEvent.toUiModel(): GameCardUiModel {
        val competition = competitions.firstOrNull()
        val competitors = competition?.competitors.orEmpty()
        val broadcast = competition?.broadcasts?.firstOrNull()?.names?.firstOrNull()
        val away = competitors.getOrNull(1)
        val home = competitors.getOrNull(0)
        val period = competition?.status?.period
        val displayClock = competition?.status?.displayClock
        val shortDetail = competition?.status?.type?.shortDetail
        val status = when(competition?.status?.type?.state) {
            "pre" -> GameStatus.UPCOMING
            "in" -> GameStatus.LIVE
            "post" -> GameStatus.FINAL
            else -> GameStatus.UPCOMING
        }
        return GameCardUiModel(
            team1 = home?.team?.shortDisplayName ?: "TBD",
            team2 = away?.team?.shortDisplayName ?: "TBD",
            team1Id = home?.id,
            team2Id = away?.id,
            team1Record = home?.records?.firstOrNull()?.summary,
            team2Record = away?.records?.firstOrNull()?.summary,
            team1Rank = home?.curatedRank?.current ?: 99,
            team2Rank = away?.curatedRank?.current ?: 99,
            team1Abr = home?.team?.abbreviation,
            team2Abr = away?.team?.abbreviation,
            startTime = formatGameTime(competition?.date), // startTime = competition?.date,
            spread = null, // add for upcoming game structure
            team1Logo = home?.team?.logo,
            team2Logo = away?.team?.logo,
            team1Color = home?.team?.color,
            team2Color = away?.team?.color,
            broadcast = broadcast,
            status = status,
            homeScore = home?.score,
            awayScore = away?.score,
            homeWinner = home?.winner,
            awayWinner = away?.winner,
            displayClock = displayClock,
            period = period,
            shortDetail = shortDetail,

            possession = null,
            shortDownDistanceText = null,
            possessionText = null


        )
    }

    // live debug
    fun loadDebugLiveGame(context: Context) {
        try {
            val json = loadJsonFromAssets(context, "live_nfl_example.json")

            val gson = Gson()
            val model = gson.fromJson(json, SportsModel::class.java)

            // Convert events to UI models
            val uiModels = model.events.orEmpty().map { it.toUiModel() }

            _gamesUiList.value = uiModels
            _sportsResult.value = NetworkResponse.Success(model)

        } catch (e: Exception) {
            _sportsResult.value = NetworkResponse.Error("Debug JSON error: ${e.message}")
        }
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