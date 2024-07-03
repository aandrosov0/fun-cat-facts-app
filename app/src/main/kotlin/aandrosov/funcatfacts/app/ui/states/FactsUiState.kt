package aandrosov.funcatfacts.app.ui.states

data class FactsUiState(
    val facts: List<FactUiState> = emptyList(),
    val message: String = "",
    val loading: Boolean = false,
)