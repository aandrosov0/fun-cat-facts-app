package aandrosov.funcatfacts.app.ui.states

sealed class ScreenState {
    data object Home : ScreenState()
    data object Favorites : ScreenState()
}