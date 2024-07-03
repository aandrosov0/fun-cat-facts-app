package aandrosov.funcatfacts.database.daos

import aandrosov.funcatfacts.database.entity.FactEntity
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface FactDao {
    @Query("SELECT * FROM fact")
    fun getAll(): List<FactEntity>

    @Insert
    fun insert(fact: FactEntity)

    @Query("DELETE FROM fact WHERE id = :id")
    fun delete(id: String)
}