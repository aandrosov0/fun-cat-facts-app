package aandrosov.funcatfacts.database.di

import aandrosov.funcatfacts.data.providers.FavoriteFactsProvider
import aandrosov.funcatfacts.database.ApplicationDatabase
import aandrosov.funcatfacts.database.providers.FavoriteFactsProviderImpl
import android.content.Context
import androidx.room.Room
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class ProvidersModule {
    @Binds
    @Singleton
    abstract fun bindFavoriteFactsProvider(provider: FavoriteFactsProviderImpl): FavoriteFactsProvider
}

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    @Provides
    @Singleton
    fun provideApplicationDatabase(@ApplicationContext context: Context): ApplicationDatabase {
        return Room.databaseBuilder(
            context = context,
            klass = ApplicationDatabase::class.java,
            name = "app-db"
        ).build()
    }
}

@Module
@InstallIn(SingletonComponent::class)
object DaosModule {
    @Provides
    @Singleton
    fun provideFactDao(database: ApplicationDatabase) = database.factDao()
}
