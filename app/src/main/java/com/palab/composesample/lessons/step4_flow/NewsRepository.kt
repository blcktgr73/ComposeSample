package com.palab.composesample.lessons.step4_flow

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class NewsRepository {

    // 학습용 가짜 데이터 소스. 실서비스라면 Retrofit/Room 등이 자리할 곳.
    fun observeArticles(): Flow<List<Article>> = flow {
        delay(800) // 첫 로딩 흉내
        emit(seed)

        // 일정 주기로 새 글이 추가되는 흐름을 흉내
        var nextId = seed.size + 1
        while (true) {
            delay(4_000)
            emit(
                listOf(Article(nextId, "새 글 #$nextId", "방금 도착한 글입니다.")) +
                    // 가장 오래된 글을 잘라내며 5개 유지
                    seed.dropLast(0).take(4),
            )
            nextId++
        }
    }

    private val seed = listOf(
        Article(1, "Compose 입문", "remember + mutableStateOf 부터 시작합니다."),
        Article(2, "Recomposition 이해", "UI = f(state) 를 체감하는 단계."),
        Article(3, "State Hoisting", "상태는 위로, 이벤트는 아래로."),
        Article(4, "Flow + StateFlow", "Reactive 한 데이터 흐름 설계."),
        Article(5, "Navigation", "Single Activity Architecture."),
    )
}
