package aandrosov.funcatfacts.app.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun FactHeader(
    text: String,
    modifier: Modifier = Modifier,
    exposed: Boolean = false,
    onExpose: () -> Unit = {},
    showExposeAction: Boolean = false,
) {
    Row(modifier = modifier) {
        Text(
            modifier = Modifier
                .padding(8.dp)
                .weight(1f),
            text = text,
            style = MaterialTheme.typography.bodyLarge
        )
        if (showExposeAction) {
            ExposeButton(
                exposed = exposed,
                onClick = onExpose
            )
        }
    }
}

@Composable
fun FactDetails(
    updatedAt: String,
    modifier: Modifier = Modifier,
    favorite: Boolean = false,
    onFavorite: () -> Unit = {},
    showFavoriteAction: Boolean = true,
) {
    Row(
        modifier = modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.End,
    ) {
        Text(
            text = updatedAt,
            textAlign = TextAlign.End,
            style = MaterialTheme.typography.labelMedium,
            modifier = Modifier.align(Alignment.CenterVertically)
        )
        if (showFavoriteAction) {
            FavoriteButton(
                favorite = favorite,
                onClick = onFavorite
            )
        }
    }
}

@Composable
fun Fact(
    text: String,
    updatedAt: String,
    modifier: Modifier = Modifier,
    favorite: Boolean = false,
    onFavorite: () -> Unit = {},
    showFavoriteAction: Boolean = true,
    exposed: Boolean = false,
    onExpose: () -> Unit = {},
    showExposeAction: Boolean = false,
) {
    Card(
        modifier = modifier
        .fillMaxWidth(),
        colors = CardDefaults.cardColors().copy(
            containerColor = MaterialTheme.colorScheme.surfaceContainer
        )
    ) {
        FactHeader(
            text = text,
            exposed = exposed,
            onExpose = onExpose,
            showExposeAction = showExposeAction
        )
        FactDetails(
            updatedAt = updatedAt,
            favorite = favorite,
            onFavorite = onFavorite,
            showFavoriteAction = showFavoriteAction
        )
    }
}

@Preview
@Composable
private fun FactHeaderPreview() {
    FactHeader(
        text = "Cats are funny!",
        showExposeAction = true
    )
}

@Preview
@Composable
private fun FactDetailsPreview() {
    FactDetails(updatedAt = "27.06.2024")
}

@Preview(showBackground = true)
@Composable
private fun FactPreview() {
    var favorite by remember { mutableStateOf(false) }
    var exposed by remember { mutableStateOf(false) }

    Fact(
        text = "Cats are funny!",
        updatedAt = "27.06.2024",
        favorite = favorite,
        onFavorite = { favorite = !favorite },
        exposed = exposed,
        onExpose = { exposed = !exposed }
    )
}