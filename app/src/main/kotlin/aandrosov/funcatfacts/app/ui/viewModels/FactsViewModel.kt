package aandrosov.funcatfacts.app.ui.viewModels

import aandrosov.funcatfacts.app.ui.states.FactsUiState
import aandrosov.funcatfacts.app.ui.states.asUiState
import aandrosov.funcatfacts.data.models.Fact
import aandrosov.funcatfacts.data.repositories.FactsRepository
import aandrosov.funcatfacts.data.repositories.FavoriteFactsRepository
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.net.SocketTimeoutException
import javax.inject.Inject

@HiltViewModel
class FactsViewModel @Inject constructor(
    private val factsRepository: FactsRepository,
    private val favoriteFactsRepository: FavoriteFactsRepository,
) : ViewModel() {
    private val _uiState = MutableStateFlow(FactsUiState())
    val uiState = _uiState.asStateFlow()

    private var getAllFavoritesJob: Job? = null
    private var getRandomFactsJob: Job? = null
    private var addToFavoritesJob: Job? = null
    private var deleteFromFavoritesJob: Job? = null

    private fun cancelJobs() {
        addToFavoritesJob?.cancel()
        deleteFromFavoritesJob?.cancel()
        getAllFavoritesJob?.cancel()
        getRandomFactsJob?.cancel()
    }

    private fun addToFavorites(fact: Fact) {
        cancelJobs()
        addToFavoritesJob = viewModelScope.launch {
            favoriteFactsRepository.add(fact)
        }
    }

    private fun deleteFromFavorites(fact: Fact) {
        cancelJobs()
        deleteFromFavoritesJob = viewModelScope.launch {
            favoriteFactsRepository.delete(fact.id)
        }
    }

    private fun toggleToFavorites(fact: Fact, favorite: Boolean) {
        viewModelScope.launch {
            if (favorite) {
                addToFavorites(fact)
            } else {
                deleteFromFavorites(fact)
            }
        }
    }

    fun getAllFavorites() {
        _uiState.value = FactsUiState(loading = true)

        cancelJobs()
        getAllFavoritesJob = viewModelScope.launch {
            val states = favoriteFactsRepository
                .getAll()
                .map { fact ->
                    fact.asUiState(favorite = true) {
                        favorite -> toggleToFavorites(fact, favorite)
                    }
                }
            _uiState.value = FactsUiState(facts = states)
        }
    }

    fun getRandomFacts(amount: Int, refresh: Boolean = false) {
        _uiState.value = FactsUiState(loading = true)

        cancelJobs()
        getRandomFactsJob = viewModelScope.launch {
            try {
                val states = factsRepository
                    .getRandomFacts(amount, refresh)
                    .map { fact ->
                        fact.asUiState(
                            favorite = favoriteFactsRepository.isFavorite(fact)
                        ) { favorite -> toggleToFavorites(fact, favorite) }
                    }
                _uiState.value = FactsUiState(facts = states)
            } catch(timeout: SocketTimeoutException) {
                _uiState.value = FactsUiState(message = "Couldn't connect to the server!")
            }
        }
    }
}

