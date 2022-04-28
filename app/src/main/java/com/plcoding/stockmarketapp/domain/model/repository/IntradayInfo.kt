package com.plcoding.stockmarketapp.domain.model.repository

import java.time.LocalDateTime

data class IntradayInfo(
    val date: LocalDateTime,
    val close: Double
)