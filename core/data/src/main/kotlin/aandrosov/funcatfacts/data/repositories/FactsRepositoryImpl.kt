package aandrosov.funcatfacts.data.repositories

import aandrosov.funcatfacts.data.models.Fact
import aandrosov.funcatfacts.data.sources.FactsDataSource
import javax.inject.Inject

class FactsRepositoryImpl @Inject constructor(
    private val remoteDataSource: FactsDataSource
) : FactsRepository {
    private var cachedRandomFacts: List<Fact> = emptyList()

    override suspend fun getFact(id: String) = remoteDataSource.getFact(id)
    override suspend fun getRandomFacts(amount: Int, refresh: Boolean): List<Fact> {
        if (refresh || cachedRandomFacts.isEmpty()) {
            cachedRandomFacts = remoteDataSource.getRandomFacts(amount)
        }
        return cachedRandomFacts
    }
}