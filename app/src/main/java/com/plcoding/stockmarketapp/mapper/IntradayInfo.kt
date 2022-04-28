package com.plcoding.stockmarketapp.mapper

import com.plcoding.stockmarketapp.domain.model.repository.CompanyInfo
import com.plcoding.stockmarketapp.domain.model.repository.IntradayInfo
import com.plcoding.stockmarketapp.remote.dto.dto.CompanyInfoDto
import com.plcoding.stockmarketapp.remote.dto.dto.IntradayInfoDto
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*

fun IntradayInfoDto.toIntradayInfo(): IntradayInfo {
    val pattern = "yyyy-MM-dd HH:mm:ss"
    val formatter = DateTimeFormatter.ofPattern(pattern, Locale.getDefault())
    val localDateTime = LocalDateTime.parse(timestamp, formatter)
    val close = 0.0
    return IntradayInfo(
        date = localDateTime,
        close = close
    )
}

