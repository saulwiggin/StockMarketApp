package com.plcoding.stockmarketapp.remote.dto.dto

import java.time.LocalDateTime

data class IntradayInfoDto(
    val timestamp: String,
    val date: LocalDateTime
)