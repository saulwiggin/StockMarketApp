package com.plcoding.stockmarketapp.mapper

import com.plcoding.stockmarketapp.domain.model.repository.CompanyListing
import com.plcoding.stockmarketapp.local.CompanyListingEntity

fun CompanyListingEntity.toCompanyListing(): CompanyListing {

    return CompanyListing(
        name = name,
        symbol = symbol,
        exchange = exchange
    )
}

fun CompanyListing.toCompanyListingEntity(): CompanyListingEntity {
    return CompanyListingEntity(
        name = name,
        symbol = symbol,
        exchange = exchange
    )
}