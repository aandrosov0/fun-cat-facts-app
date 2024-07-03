package aandrosov.funcatfacts.app.ui.components

import aandrosov.funcatfacts.app.ui.viewModels.FactsViewModel
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun FavoritesScreen(
    modifier: Modifier = Modifier,
    factsViewModel: FactsViewModel = viewModel()
) {
    val state by factsViewModel.uiState.collectAsState()

    LaunchedEffect(Unit) {
        factsViewModel.getAllFavorites()
    }

    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (!state.loading) {
            Facts(facts = state.facts.reversed())
        }
    }
}