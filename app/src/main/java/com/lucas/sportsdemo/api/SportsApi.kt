package com.lucas.sportsdemo.api

import okhttp3.ResponseBody // problem
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

    @GET("apis/site/v2/sports/{sport}/{league}/scoreboard")
    suspend fun getBasketballGames(
        @retrofit2.http.Path("sport") sport: String,
        @retrofit2.http.Path("league") league: String,
        @Query("dates") date: String?
    ) : Response<BasketballModel>

    @GET("apis/site/v2/sports/{sport}/{league}/summary")
    suspend fun getGameDetailRaw(
        @retrofit2.http.Path("sport") sport: String,
        @retrofit2.http.Path("league") league: String,
        @Query("event") gameId: String?
    ): Response<ResponseBody>// Response<GameDetailModel>

    @GET("apis/site/v2/sports/{sport}/{league}/summary")
    suspend fun getGameDetail(
        @retrofit2.http.Path("sport") sport: String,
        @retrofit2.http.Path("league") league: String,
        @Query("event") gameId: String?
    ): Response<GameDetailModel>


    @GET("apis/site/v2/sports/{sport}/{league}/summary")
    suspend fun getRawGameJson(
        @retrofit2.http.Path("sport") sport: String,
        @retrofit2.http.Path("league") league: String,
        @Query("event") date: String,
    ): Response<ResponseBody> // this is okhttp3 not retrofit 2

    @GET("apis/site/v2/sports/{sport}/{league}/scoreboard")
    suspend fun getRawJson(
        @retrofit2.http.Path("sport") sport: String,
        @retrofit2.http.Path("league") league: String,
        @Query("dates") date: String,
    ): Response<ResponseBody> // this is okhttp3 not retrofit 2

}