package com.palab.composesample.lessons.capstone_dashboard

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlin.math.max
import kotlin.math.min
import kotlin.random.Random

data class HazardEvent(val id: Long, val label: String)

data class TripState(
    val speedKmh: Int,
    val totalKm: Double,
    val hazards: List<HazardEvent>,
)

class TripRepository {

    fun observeTrip(): Flow<TripState> = flow {
        var speed = 0
        var totalKm = 0.0
        val hazards = ArrayDeque<HazardEvent>()
        var hazardId = 0L

        while (true) {
            // 속도 변화 시뮬레이션
            val delta = Random.nextInt(-8, 12)
            speed = max(0, min(140, speed + delta))

            // 1초당 km 누적 (단순화)
            totalKm += speed / 3600.0

            // 위험 이벤트 랜덤 발생
            if (speed > 100 && Random.nextInt(100) < 15) {
                hazardId += 1
                hazards.addFirst(HazardEvent(hazardId, "과속 경고 (${speed} km/h)"))
                if (hazards.size > 8) hazards.removeLast()
            } else if (Random.nextInt(100) < 5) {
                hazardId += 1
                hazards.addFirst(HazardEvent(hazardId, "급가속 감지"))
                if (hazards.size > 8) hazards.removeLast()
            }

            emit(
                TripState(
                    speedKmh = speed,
                    totalKm = totalKm,
                    hazards = hazards.toList(),
                ),
            )
            delay(1_000)
        }
    }
}
