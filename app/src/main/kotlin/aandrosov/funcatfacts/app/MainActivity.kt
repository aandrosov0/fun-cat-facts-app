package aandrosov.funcatfacts.app

import aandrosov.funcatfacts.app.ui.components.BottomNavigationBar
import aandrosov.funcatfacts.app.ui.components.FactsTopAppBar
import aandrosov.funcatfacts.app.ui.components.FavoritesScreen
import aandrosov.funcatfacts.app.ui.components.HomeScreen
import aandrosov.funcatfacts.app.ui.states.ScreenState
import aandrosov.funcatfacts.app.ui.theme.AppTheme
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.toArgb
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            AppTheme {
                window.statusBarColor = MaterialTheme.colorScheme.surfaceContainer.toArgb()
                AppScreen()
            }
        }
    }
}

@Composable
fun AppScreen(
    modifier: Modifier = Modifier,
    initialScreen: ScreenState = ScreenState.Home
) {
    var currentScreenState by remember { mutableStateOf(initialScreen) }

    Scaffold(
        modifier = modifier,
        topBar = {
            FactsTopAppBar()
        },
        bottomBar = {
            BottomNavigationBar(
                screenState = currentScreenState,
                onHome = { currentScreenState = ScreenState.Home },
                onFavorites = { currentScreenState = ScreenState.Favorites }
            )
        }
    ) { padding ->
        when (currentScreenState) {
            ScreenState.Home -> HomeScreen(modifier = Modifier.padding(padding))
            ScreenState.Favorites -> FavoritesScreen(modifier = Modifier.padding(padding))
        }
    }
}