package com.plcoding.stockmarketapp.di

import com.plcoding.stockmarketapp.csv.CSVParser
import com.plcoding.stockmarketapp.csv.CompanyListingsParser
import com.plcoding.stockmarketapp.domain.model.repository.CompanyListing
import com.plcoding.stockmarketapp.repository.StockRepository
import com.plcoding.stockmarketapp.repository.StockRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindCompanyListingsParser(
        companyListingsParser: CompanyListingsParser
    ): CSVParser<CompanyListing>

    @Binds
    @Singleton
    abstract fun bindStockRepository(
        stockRepositoryImpl: StockRepositoryImpl
    ): StockRepository
}