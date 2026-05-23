package com.palab.composesample.lessons.step4_flow

data class Article(
    val id: Int,
    val title: String,
    val body: String,
)

sealed interface NewsUiState {
    data object Loading : NewsUiState
    data class Success(val articles: List<Article>) : NewsUiState
    data class Error(val message: String) : NewsUiState
}
