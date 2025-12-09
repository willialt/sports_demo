package com.lucas.sportsdemo.api.extraModels

data class Mobile(
    val alert: Alert,
    val progressiveDownload: ProgressiveDownload,
    val source: Source,
    val streaming: Streaming
)