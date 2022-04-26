package com.plcoding.stockmarketapp.presentation.company_info.company_listings

import com.plcoding.stockmarketapp.domain.model.repository.CompanyListing
import java.lang.Boolean.FALSE

data class CompanyListingsState (
    val companies: List<CompanyListing> = emptyList(),
    val isLoading: Boolean = FALSE,
    val isRefreshing: Boolean = FALSE,
    val searchQuery: String =""
) {

}