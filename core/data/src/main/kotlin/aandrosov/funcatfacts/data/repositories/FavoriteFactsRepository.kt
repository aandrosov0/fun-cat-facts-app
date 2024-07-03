package aandrosov.funcatfacts.data.repositories

import aandrosov.funcatfacts.data.models.Fact

interface FavoriteFactsRepository {
    suspend fun getAll(): List<Fact>
    suspend fun add(fact: Fact)
    suspend fun delete(id: String)
    suspend fun isFavorite(fact: Fact): Boolean
}