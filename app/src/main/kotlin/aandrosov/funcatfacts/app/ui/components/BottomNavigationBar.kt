package aandrosov.funcatfacts.app.ui.components

import aandrosov.funcatfacts.app.ui.states.ScreenState
import aandrosov.funcatfacts.app.ui.theme.AppTheme
import androidx.compose.foundation.background
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun BottomNavigationBar(
    screenState: ScreenState,
    onHome: () -> Unit,
    onFavorites: () -> Unit,
    modifier: Modifier = Modifier
) {
    NavigationBar(
        modifier = modifier
            .background(
                color = MaterialTheme.colorScheme.surfaceContainer,
                shape = RoundedCornerShape(
                    topStart = 12.dp,
                    topEnd = 12.dp
                )
            ),
        containerColor = Color.Transparent,
        contentColor = Color.Transparent
    ) {
        NavigationBarItem(
            selected = screenState == ScreenState.Home,
            onClick = onHome,
            icon = {
                Icon(
                    imageVector = Icons.Filled.Home,
                    contentDescription = null
                )
            }
        )
        NavigationBarItem(
            selected = screenState == ScreenState.Favorites,
            onClick = onFavorites,
            icon = {
                Icon(
                    imageVector = Icons.Filled.Favorite,
                    contentDescription = null
                )
            }
        )
    }
}

@Preview
@Composable
private fun BottomNavigationBarPreview() {
    AppTheme {
        BottomNavigationBar(
            screenState = ScreenState.Home,
            onHome = { },
            onFavorites = { }
        )
    }
}