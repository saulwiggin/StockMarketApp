package com.plcoding.stockmarketapp.domain.model.repository

import androidx.room.PrimaryKey

data class CompanyListing (
    val name: String,
    val symbol: String,
    val exchange: String,
    @PrimaryKey val id: Int? = null
)