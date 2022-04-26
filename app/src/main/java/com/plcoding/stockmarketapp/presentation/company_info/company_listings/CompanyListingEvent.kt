package com.plcoding.stockmarketapp.presentation.company_info.company_listings

sealed class CompanyListingEvent {
    object Refresh: CompanyListingEvent()
    data class OnSearchQueryChange(val query: String): CompanyListingEvent()
}