package aandrosov.funcatfacts.database.entity

import aandrosov.funcatfacts.data.models.Fact
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "fact")
data class FactEntity(
    @PrimaryKey val id: String,
    @ColumnInfo val text: String,
    @ColumnInfo(name = "updated_at") val updatedAt: String,
)

fun FactEntity.asExternalModel() = Fact(
    id = id,
    text = text,
    updatedAt = updatedAt
)

