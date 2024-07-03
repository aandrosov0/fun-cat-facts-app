package aandrosov.funcatfacts.data.providers

import aandrosov.funcatfacts.data.models.Fact
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface FactsProvider {
    @GET("/facts/{id}")
    suspend fun getFact(@Path("id") id: String): Fact

    @GET("/facts/random?amount=1&animal_type=cat")
    suspend fun getRandomFact(): Fact

    @GET("/facts/random?animal_type=cat")
    suspend fun getRandomFacts(@Query("amount") amount: Int): List<Fact>
}