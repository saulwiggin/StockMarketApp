package com.plcoding.stockmarketapp.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.plcoding.stockmarketapp.dao.StockDao
import com.plcoding.stockmarketapp.local.CompanyListingEntity

@Database(
    entities = [CompanyListingEntity::class],
    version = 1
)
abstract class StockDatabase: RoomDatabase() {
    abstract  val dao: StockDao
}