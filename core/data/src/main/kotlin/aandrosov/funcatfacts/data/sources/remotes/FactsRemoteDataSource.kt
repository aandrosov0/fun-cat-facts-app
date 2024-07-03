package aandrosov.funcatfacts.data.sources.remotes

import aandrosov.funcatfacts.data.providers.FactsProvider
import aandrosov.funcatfacts.data.sources.FactsDataSource
import javax.inject.Inject

class FactsRemoteDataSource @Inject constructor(
    private val provider: FactsProvider
) : FactsDataSource {
    override suspend fun getFact(id: String) = provider.getFact(id)
    override suspend fun getRandomFacts(amount: Int) = when {
        amount == 1 -> listOf(provider.getRandomFact())
        amount > 1 -> provider.getRandomFacts(amount)
        else -> throw IllegalArgumentException("The amount parameter \"$amount\" is illegal!")
    }
}