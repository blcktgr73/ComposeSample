package com.palab.composesample.lessons.capstone_dashboard

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn

class DashboardViewModel(
    private val repository: TripRepository = TripRepository(),
) : ViewModel() {

    val tripState: StateFlow<TripState> = repository.observeTrip()
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000),
            initialValue = TripState(speedKmh = 0, totalKm = 0.0, hazards = emptyList()),
        )
}
