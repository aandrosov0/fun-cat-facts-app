package aandrosov.funcatfacts.app.ui.components

import aandrosov.funcatfacts.app.ui.states.FactUiState
import aandrosov.funcatfacts.app.ui.states.getFacts
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

const val MAX_TEXT_LENGTH = 36

@Composable
fun Facts(
    facts: List<FactUiState>,
    modifier: Modifier = Modifier,
) {
    LazyColumn(
        modifier = modifier,
        contentPadding = PaddingValues(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        items(items = facts) { fact ->
            var favorite by remember { mutableStateOf(fact.favorite) }
            var exposed by remember { mutableStateOf(fact.text.length <= MAX_TEXT_LENGTH) }
            val text = if (!exposed) {
                fact.text.substring(0, MAX_TEXT_LENGTH)
            } else {
                fact.text
            }

            Fact(
                text = text,
                updatedAt = fact.updatedAt,
                favorite = favorite,
                onFavorite = {
                    favorite = !favorite
                    fact.onFavorite(favorite)
                },
                exposed = exposed,
                onExpose =  { exposed = !exposed },
                showExposeAction = fact.text.length > MAX_TEXT_LENGTH
            )
        }
    }
}

@Preview
@Composable
private fun FactsPreview() {
    Facts(facts = getFacts())
}