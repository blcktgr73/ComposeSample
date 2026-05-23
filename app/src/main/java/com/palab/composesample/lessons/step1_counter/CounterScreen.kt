package com.palab.composesample.lessons.step1_counter

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.palab.composesample.ui.components.LessonScaffold

@Composable
fun CounterScreen(onBack: () -> Unit) {
    LessonScaffold(
        title = "STEP 1 · Counter",
        hint = "count 변경 → 같은 Composable 함수가 다시 실행됨 (Recomposition)",
        onBack = onBack,
    ) { padding ->
        var count by remember { mutableIntStateOf(0) }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(24.dp),
            verticalArrangement = Arrangement.spacedBy(24.dp, Alignment.CenterVertically),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(
                text = "$count",
                style = MaterialTheme.typography.displayLarge,
            )

            Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                OutlinedButton(onClick = { count-- }) { Text("감소") }
                Button(onClick = { count++ }) { Text("증가") }
            }

            OutlinedButton(onClick = { count = 0 }) { Text("리셋") }
        }
    }
}
