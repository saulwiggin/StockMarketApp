package com.plcoding.stockmarketapp.repository

import com.plcoding.stockmarketapp.domain.model.repository.CompanyListing
import com.plcoding.stockmarketapp.util.Resource
import kotlinx.coroutines.flow.Flow

interface StockRepository {
    suspend fun getCompanyListings(
        fetchFromRemote: Boolean,
        query: String
    ): Flow<Resource<List<CompanyListing>>>
}