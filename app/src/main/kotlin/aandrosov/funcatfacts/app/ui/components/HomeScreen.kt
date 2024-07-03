package aandrosov.funcatfacts.app.ui.components

import aandrosov.funcatfacts.app.ui.viewModels.FactsViewModel
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.lifecycle.viewmodel.compose.viewModel

const val RANDOM_FACTS_COUNT = 10

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    factsViewModel: FactsViewModel = viewModel(),
) {
    val state by factsViewModel.uiState.collectAsState()
    LaunchedEffect(Unit) {
        factsViewModel.getRandomFacts(RANDOM_FACTS_COUNT)
    }

    Box(modifier = modifier.fillMaxSize()) {
        if (!state.loading) {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Facts(facts = state.facts.reversed())
                if (state.message.isNotBlank()) {
                    Text(
                        modifier = Modifier.fillMaxWidth(),
                        text = state.message,
                        style = MaterialTheme.typography.bodyLarge,
                        textAlign = TextAlign.Center
                    )
                }
            }
            FloatingRefreshButton(
                modifier = Modifier.align(Alignment.BottomEnd),
                onClick = {
                    factsViewModel.getRandomFacts(
                        amount = RANDOM_FACTS_COUNT,
                        refresh = true
                    )
                }
            )
        } else {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }
    }
}