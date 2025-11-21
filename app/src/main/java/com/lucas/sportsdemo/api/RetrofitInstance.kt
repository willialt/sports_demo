package com.lucas.sportsdemo.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    private const val baseUrl = "https://site.api.espn.com/"
    private fun getInstance(): Retrofit
    {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create()) // added (gson)
            .build()
    }
    val sportsApi : SportsApi = getInstance().create(SportsApi::class.java)
    val basketballApi : BasketballApi = getInstance().create(BasketballApi::class.java) // new instance
}