package com.lucas.sportsdemo.api.ncaamModels

data class Mobile(
    val alert: Alert,
    val progressiveDownload: ProgressiveDownload,
    val source: Source,
    val streaming: Streaming
)