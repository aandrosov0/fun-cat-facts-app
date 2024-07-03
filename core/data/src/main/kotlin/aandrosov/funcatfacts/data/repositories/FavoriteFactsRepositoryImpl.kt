package aandrosov.funcatfacts.data.repositories

import aandrosov.funcatfacts.data.models.Fact
import aandrosov.funcatfacts.data.sources.FavoriteFactsDataSource
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class FavoriteFactsRepositoryImpl @Inject constructor(
    private val favoriteFactsDataSource: FavoriteFactsDataSource,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO,
) : FavoriteFactsRepository {
    override suspend fun getAll() = withContext(dispatcher) {
        favoriteFactsDataSource.getAll()
    }
    override suspend fun add(fact: Fact) = withContext(dispatcher) {
        favoriteFactsDataSource.add(fact)
    }
    override suspend fun delete(id: String) = withContext(dispatcher) {
        favoriteFactsDataSource.delete(id)
    }
    override suspend fun isFavorite(fact: Fact) = withContext(dispatcher) {
        favoriteFactsDataSource.getAll().contains(fact)
    }
}