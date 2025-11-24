package com.lucas.sportsdemo.api

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface SportsApi {

//    @GET("apis/site/v2/sports/football/college-football/scoreboard")
    @GET("apis/site/v2/sports/football/{league}/scoreboard")
    suspend fun getFootballGames( // changed from getGames
        // weather has key and q, cfb has calendar and dates
    @retrofit2.http.Path("league") league: String,
    @Query("week") week : Int? = null,
    @Query("dates") year : Int? = null,
    @Query("seasontype") seasonType : Int? = null,
    @Query("groups") groups : Int? = null
    ) : Response<SportsModel>
}