package com.plcoding.stockmarketapp.mapper

import com.plcoding.stockmarketapp.domain.model.repository.CompanyInfo
import com.plcoding.stockmarketapp.remote.dto.dto.CompanyInfoDto

fun CompanyInfoDto.toCompanyInfo(): CompanyInfo {
    return CompanyInfo(
        symbol = symbol ?: "",
        description = description ?: "",
        name = name ?: "",
        country = country ?: "",
        industry = industry ?: "",
    )
}