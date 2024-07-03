package aandrosov.funcatfacts.app.ui.components

import aandrosov.funcatfacts.app.ui.theme.AppTheme
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun FloatingRefreshButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    FloatingActionButton(
        modifier = modifier.padding(8.dp),
        onClick = onClick
    ) {
        Icon(
            imageVector = Icons.Filled.Refresh,
            contentDescription = null
        )
    }
}

@Composable
fun FavoriteButton(
    favorite: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    IconButton(
        modifier = modifier,
        onClick = onClick
    ) {
        val favoriteIconId = if (favorite) Icons.Filled.Favorite else Icons.Filled.FavoriteBorder
        Icon(
            imageVector = favoriteIconId,
            contentDescription = null
        )
    }
}

@Composable
fun ExposeButton(
    exposed: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    IconButton(
        modifier = modifier,
        onClick = onClick
    ) {
        val iconId = if (exposed) {
            Icons.Filled.KeyboardArrowDown
        } else {
            Icons.Filled.KeyboardArrowUp
        }

        Icon(imageVector = iconId, contentDescription = null)
    }
}


@Preview
@Composable
private fun RefreshButtonPreview() {
    AppTheme {
        FloatingRefreshButton(onClick = {})
    }
}

@Preview
@Composable
private fun FavoriteButtonPreview() {
    var favorite by remember { mutableStateOf(false) }
    FavoriteButton(
        favorite = favorite,
        onClick = { favorite = !favorite }
    )
}

@Preview
@Composable
private fun ExposeButtonPreview() {
    var exposed by remember { mutableStateOf(false) }
    ExposeButton(
        exposed = exposed,
        onClick = { exposed = !exposed }
    )
}

