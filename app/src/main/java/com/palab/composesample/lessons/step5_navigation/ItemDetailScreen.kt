package com.palab.composesample.lessons.step5_navigation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.palab.composesample.ui.components.LessonScaffold

@Composable
fun ItemDetailScreen(
    itemId: Int,
    onBack: () -> Unit,
) {
    val item = demoItems.firstOrNull { it.id == itemId }

    LessonScaffold(
        title = "STEP 5 · Detail",
        hint = "argument 로 itemId 전달 → 같은 NavGraph 내에서 다른 화면 상태로 전환",
        onBack = onBack,
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(24.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp),
        ) {
            Text(text = "itemId = $itemId", style = MaterialTheme.typography.titleMedium)
            Text(
                text = item?.title ?: "찾을 수 없음",
                style = MaterialTheme.typography.headlineSmall,
            )
            Text(
                text = "여기까지 오는 데 사용된 것: NavController.navigate(\"step5/detail/\$id\")",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
            )
        }
    }
}
