package aandrosov.funcatfacts.data.sources.locals

import aandrosov.funcatfacts.data.models.Fact
import aandrosov.funcatfacts.data.providers.FavoriteFactsProvider
import aandrosov.funcatfacts.data.sources.FavoriteFactsDataSource
import javax.inject.Inject

class FavoriteFactsLocalDataSource @Inject constructor(
    private val favoriteFactsProvider: FavoriteFactsProvider
) : FavoriteFactsDataSource {
    override fun getAll() = favoriteFactsProvider.getAll()
    override fun add(fact: Fact) = favoriteFactsProvider.insert(fact)
    override fun delete(id: String) = favoriteFactsProvider.delete(id)
}