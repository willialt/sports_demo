package com.lucas.sportsdemo.api

import com.lucas.sportsdemo.api.gameDetailModels.AgainstTheSpread
import com.lucas.sportsdemo.api.gameDetailModels.BettingOdds
import com.lucas.sportsdemo.api.gameDetailModels.Boxscore
import com.lucas.sportsdemo.api.gameDetailModels.Drives
import com.lucas.sportsdemo.api.gameDetailModels.Format
import com.lucas.sportsdemo.api.gameDetailModels.GameInfo
import com.lucas.sportsdemo.api.gameDetailModels.Header
import com.lucas.sportsdemo.api.gameDetailModels.Injury
import com.lucas.sportsdemo.api.gameDetailModels.Leader
import com.lucas.sportsdemo.api.gameDetailModels.Meta
import com.lucas.sportsdemo.api.gameDetailModels.News
import com.lucas.sportsdemo.api.gameDetailModels.Predictor
import com.lucas.sportsdemo.api.gameDetailModels.ScoringPlay
import com.lucas.sportsdemo.api.gameDetailModels.Standings
import com.lucas.sportsdemo.api.gameDetailModels.Winprobability

data class GameDetailModel(
//    val againstTheSpread: List<AgainstTheSpread>,
//    val boxscore: Boxscore?,
//    val broadcasts: List<Any?>,
    val drives: Drives?,
//    val format: Format,
//    val gameInfo: GameInfo,
    val header: Header?,
//    val injuries: List<Injury>,
//    val leaders: List<Leader>,
//    val meta: Meta,
//    val news: News,
//    val odds: List<Any?>,
    val predictor: Predictor?,
    val pickcenter: List<BettingOdds?>?
//    val scoringPlays: List<ScoringPlay>,
//    val standings: Standings,
//    val videos: List<Any?>,
//    val wallclockAvailable: Boolean,
//    val winprobability: List<Winprobability>
)