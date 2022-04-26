package com.plcoding.stockmarketapp.dao

import android.icu.lang.UCharacter.SentenceBreak.LOWER
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.plcoding.stockmarketapp.local.CompanyListingEntity

@Dao
interface StockDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCompanyListings(
        companyListingEntities: List<CompanyListingEntity>
    )

    @Query("DELETE FROM CompanyListingEntity")
    suspend fun clearCompanyLitings()

    @Query(
        """
    SELECT *
    FROM companylistingentity
    WHERE LOWER(name) LIKE '%' || LOWER(:query) || '%' OR
                UPPER(:query) == symbol
        """
    )

    suspend fun searchCompanyListing(query: String): List<CompanyListingEntity>
}