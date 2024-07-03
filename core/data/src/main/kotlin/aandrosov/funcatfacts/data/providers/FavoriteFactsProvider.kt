package aandrosov.funcatfacts.data.providers

import aandrosov.funcatfacts.data.models.Fact

interface FavoriteFactsProvider {
    fun getAll(): List<Fact>
    fun insert(fact: Fact)
    fun delete(id: String)
}