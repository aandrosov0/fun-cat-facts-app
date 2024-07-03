package aandrosov.funcatfacts.data.sources

import aandrosov.funcatfacts.data.models.Fact

interface FavoriteFactsDataSource {
    fun getAll(): List<Fact>
    fun add(fact: Fact)
    fun delete(id: String)
}