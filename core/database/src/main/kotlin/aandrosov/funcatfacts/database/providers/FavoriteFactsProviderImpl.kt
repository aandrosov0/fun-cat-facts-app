package aandrosov.funcatfacts.database.providers

import aandrosov.funcatfacts.data.models.Fact
import aandrosov.funcatfacts.data.providers.FavoriteFactsProvider
import aandrosov.funcatfacts.database.daos.FactDao
import aandrosov.funcatfacts.database.entity.FactEntity
import aandrosov.funcatfacts.database.entity.asExternalModel
import javax.inject.Inject

class FavoriteFactsProviderImpl @Inject constructor(
    private val factDao: FactDao
) : FavoriteFactsProvider {
    override fun getAll() = factDao.getAll().map(FactEntity::asExternalModel)

    override fun insert(fact: Fact) = factDao.insert(FactEntity(
        id = fact.id,
        text = fact.text,
        updatedAt = fact.updatedAt
    ))

    override fun delete(id: String) = factDao.delete(id)
}