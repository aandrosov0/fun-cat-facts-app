package aandrosov.funcatfacts.database

import aandrosov.funcatfacts.database.daos.FactDao
import aandrosov.funcatfacts.database.entity.FactEntity
import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [FactEntity::class], version = 1)
abstract class ApplicationDatabase : RoomDatabase() {
    abstract fun factDao(): FactDao
}