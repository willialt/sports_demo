package com.lucas.sportsdemo.api

import retrofit2.Response
import retrofit2.http.GET

interface BasketballApi {

    @GET("apis/site/v2/sports/basketball/{league}/scoreboard")
    suspend fun getBasketballGames(
        @retrofit2.http.Path("league") league: String
    ): Response<BasketballModel>
}