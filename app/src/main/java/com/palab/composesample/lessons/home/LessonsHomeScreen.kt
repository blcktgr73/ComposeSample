package com.palab.composesample.lessons.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.palab.composesample.navigation.Destinations
import com.palab.composesample.ui.components.LessonScaffold

private data class LessonEntry(
    val title: String,
    val subtitle: String,
    val route: String,
)

private val lessons = listOf(
    LessonEntry(
        title = "STEP 1 · Counter",
        subtitle = "State → Recomposition 체감",
        route = Destinations.STEP1_COUNTER,
    ),
    LessonEntry(
        title = "STEP 2 · Login",
        subtitle = "derivedStateOf · state hoisting",
        route = Destinations.STEP2_LOGIN,
    ),
    LessonEntry(
        title = "STEP 3 · List + Search",
        subtitle = "LazyColumn · state filtering",
        route = Destinations.STEP3_SEARCH,
    ),
    LessonEntry(
        title = "STEP 4 · ViewModel + Flow",
        subtitle = "StateFlow · collectAsStateWithLifecycle",
        route = Destinations.STEP4_FLOW,
    ),
    LessonEntry(
        title = "STEP 5 · Navigation",
        subtitle = "NavHost · nested graph · args",
        route = Destinations.STEP5_GRAPH,
    ),
    LessonEntry(
        title = "STEP 6 · Hybrid UI",
        subtitle = "AndroidView로 WebView 임베드",
        route = Destinations.STEP6_HYBRID,
    ),
    LessonEntry(
        title = "★ Capstone · Driving Dashboard",
        subtitle = "Flow · StateFlow · Canvas · 종합",
        route = Destinations.CAPSTONE_DASHBOARD,
    ),
)

@Composable
fun LessonsHomeScreen(
    onLessonClick: (route: String) -> Unit,
) {
    LessonScaffold(title = "Compose 학습 샘플") { padding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp),
        ) {
            items(lessons, key = { it.route }) { lesson ->
                LessonCard(lesson = lesson, onClick = { onLessonClick(lesson.route) })
            }
        }
    }
}

@Composable
private fun LessonCard(lesson: LessonEntry, onClick: () -> Unit) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        onClick = onClick,
    ) {
        androidx.compose.foundation.layout.Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(4.dp),
        ) {
            Text(text = lesson.title, style = MaterialTheme.typography.titleMedium)
            Text(
                text = lesson.subtitle,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
            )
        }
    }
}
