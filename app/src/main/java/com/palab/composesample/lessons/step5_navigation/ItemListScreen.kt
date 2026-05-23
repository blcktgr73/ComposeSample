package com.palab.composesample.lessons.step5_navigation

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
import com.palab.composesample.ui.components.LessonScaffold

internal data class DemoItem(val id: Int, val title: String)

internal val demoItems = (1..20).map { DemoItem(it, "아이템 #$it") }

@Composable
fun ItemListScreen(
    onItemClick: (Int) -> Unit,
    onBack: () -> Unit,
) {
    LessonScaffold(
        title = "STEP 5 · List",
        hint = "현재 화면을 '쌓아 올린다' → NavController 가 back stack 관리",
        onBack = onBack,
    ) { padding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            items(demoItems, key = { it.id }) { item ->
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    onClick = { onItemClick(item.id) },
                ) {
                    Text(
                        text = item.title,
                        style = MaterialTheme.typography.titleSmall,
                        modifier = Modifier.padding(16.dp),
                    )
                }
            }
        }
    }
}
