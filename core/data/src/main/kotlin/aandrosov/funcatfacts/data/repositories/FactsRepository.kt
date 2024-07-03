package aandrosov.funcatfacts.data.repositories

import aandrosov.funcatfacts.data.models.Fact

interface FactsRepository {
    suspend fun getFact(id: String): Fact
    suspend fun getRandomFacts(amount: Int, refresh: Boolean = false): List<Fact>
}