package aandrosov.funcatfacts.data.di

import aandrosov.funcatfacts.data.providers.FactsProvider
import aandrosov.funcatfacts.data.repositories.FactsRepository
import aandrosov.funcatfacts.data.repositories.FactsRepositoryImpl
import aandrosov.funcatfacts.data.repositories.FavoriteFactsRepository
import aandrosov.funcatfacts.data.repositories.FavoriteFactsRepositoryImpl
import aandrosov.funcatfacts.data.sources.FactsDataSource
import aandrosov.funcatfacts.data.sources.FavoriteFactsDataSource
import aandrosov.funcatfacts.data.sources.locals.FavoriteFactsLocalDataSource
import aandrosov.funcatfacts.data.sources.remotes.FactsRemoteDataSource
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.Dispatchers
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoriesModule {
    @Singleton
    @Binds
    abstract fun bindFactsRepository(repository: FactsRepositoryImpl): FactsRepository

    @Singleton
    @Binds
    abstract fun bindFavoritesFactsRepository(repository: FavoriteFactsRepositoryImpl): FavoriteFactsRepository
}

@Module
@InstallIn(SingletonComponent::class)
abstract class DataSourcesModule {
    @Singleton
    @Binds
    abstract fun bindFactsDataSource(source: FactsRemoteDataSource): FactsDataSource

    @Singleton
    @Binds
    abstract fun bindFavoriteFactsDataSource(source: FavoriteFactsLocalDataSource): FavoriteFactsDataSource
}

@Module
@InstallIn(SingletonComponent::class)
object ProvidersModule {
    @Singleton
    @Provides
    fun provideFactsProvider(): FactsProvider {
        return Retrofit.Builder()
            .baseUrl("https://cat-fact.herokuapp.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(FactsProvider::class.java)
    }
}

@Module
@InstallIn(SingletonComponent::class)
object Dispatchers {
    @Singleton
    @Provides
    fun provideCoroutineDispatcher() = Dispatchers.IO
}