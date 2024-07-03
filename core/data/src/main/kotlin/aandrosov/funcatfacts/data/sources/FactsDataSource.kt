package aandrosov.funcatfacts.data.sources

import aandrosov.funcatfacts.data.models.Fact

interface FactsDataSource {
    suspend fun getFact(id: String): Fact
    suspend fun getRandomFacts(amount: Int = 1): List<Fact>
}