package com.plcoding.stockmarketapp.repository

import com.opencsv.CSVReader
import com.plcoding.stockmarketapp.csv.CSVParser
import com.plcoding.stockmarketapp.csv.CompanyListingsParser
import com.plcoding.stockmarketapp.domain.model.repository.CompanyListing
import com.plcoding.stockmarketapp.mapper.toCompanyListing
import com.plcoding.stockmarketapp.mapper.toCompanyListingEntity
import com.plcoding.stockmarketapp.remote.dto.stockApi
import com.plcoding.stockmarketapp.room.StockDatabase
import com.plcoding.stockmarketapp.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class StockRepositoryImpl @Inject constructor(
    val api: stockApi,
    val db: StockDatabase,
    val companyListingParser: CSVParser<CompanyListing>
): StockRepository {
    private val dao = db.dao
    override suspend fun getCompanyListings(
        fetchFromRemote: Boolean,
        query: String
    ): Flow<Resource<List<CompanyListing>>> {

        return flow {
            emit(Resource.Loading(true))
            val localListings = dao.searchCompanyListing(query)
            emit(Resource.Success(
                data = localListings.map { it.toCompanyListing() }
            ))

            val isDbEmpty = localListings.isEmpty() && query.isBlank()
            val shouldJustLoadFromCache = !isDbEmpty && !fetchFromRemote
            if(shouldJustLoadFromCache){
                emit(Resource.Loading(false))
                return@flow
            }

            val remoteListings = try {
                val response = api.getListings()
                companyListingParser.parse(response.byteStream())
            } catch(e: IOException){
                emit(Resource.Error("couldn't load data"))
                null
            } catch(e: HttpException){
                e.printStackTrace()
                emit(Resource.Error("couldn't load data"))
                null
            }

            remoteListings?.let { listings ->

                dao.clearCompanyLitings()
                dao.insertCompanyListings(listings.map { it.toCompanyListingEntity()})

                emit(Resource.Success(
                    data = dao.searchCompanyListing("")
                        .map { it.toCompanyListing() }
                ))
                emit(Resource.Loading(false))
            }
        }
    }
}