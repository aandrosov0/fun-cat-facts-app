package aandrosov.funcatfacts.app.ui.states

import aandrosov.funcatfacts.data.models.Fact

data class FactUiState(
    val text: String = "",
    val updatedAt: String = "",
    val favorite: Boolean = false,
    val onFavorite: (Boolean) -> Unit = {},
)

fun Fact.asUiState(favorite: Boolean, onFavorite: (Boolean) -> Unit) = FactUiState(
    text = text,
    updatedAt = updatedAt.substringBefore('T').replace('-', '.'),
    favorite = favorite,
    onFavorite = onFavorite
)

fun getFacts() = buildList {
    for (i in 1..5) {
        add(
            FactUiState(
                text = "Fact Title",
                updatedAt = "12.04.2024",
            )
        )
    }
}