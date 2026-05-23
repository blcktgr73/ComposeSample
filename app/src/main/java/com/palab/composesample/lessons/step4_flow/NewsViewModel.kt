package com.palab.composesample.lessons.step4_flow

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

class NewsViewModel(
    private val repository: NewsRepository = NewsRepository(), // 수동 DI
) : ViewModel() {

    val uiState: StateFlow<NewsUiState> = repository.observeArticles()
        .map<List<Article>, NewsUiState> { NewsUiState.Success(it) }
        .catch { emit(NewsUiState.Error(it.message ?: "알 수 없는 오류")) }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000),
            initialValue = NewsUiState.Loading,
        )
}
