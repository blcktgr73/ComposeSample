package com.palab.composesample.lessons.step3_search

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.palab.composesample.ui.components.LessonScaffold

@Composable
fun UserSearchScreen(onBack: () -> Unit) {
    LessonScaffold(
        title = "STEP 3 · List + Search",
        hint = "리스트를 '갱신' 하지 않는다. 현재 키워드로 'filter된 결과'를 선언할 뿐.",
        onBack = onBack,
    ) { padding ->
        var keyword by remember { mutableStateOf("") }

        // 키워드가 바뀌면 filtered 결과가 새로 계산되고,
        // LazyColumn 은 새 리스트 기반으로 recomposition.
        val filtered = remember(keyword) {
            if (keyword.isBlank()) fakeUsers
            else fakeUsers.filter {
                it.name.contains(keyword, ignoreCase = true) ||
                    it.email.contains(keyword, ignoreCase = true)
            }
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding),
        ) {
            OutlinedTextField(
                value = keyword,
                onValueChange = { keyword = it },
                label = { Text("이름 / 이메일 검색") },
                singleLine = true,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
            )

            Text(
                text = "${filtered.size}명",
                style = MaterialTheme.typography.labelMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                modifier = Modifier.padding(horizontal = 16.dp),
            )

            LazyColumn(
                contentPadding = PaddingValues(vertical = 8.dp),
                verticalArrangement = Arrangement.spacedBy(0.dp),
            ) {
                items(filtered, key = { it.id }) { user ->
                    UserRow(user)
                    HorizontalDivider()
                }
            }
        }
    }
}

@Composable
private fun UserRow(user: User) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 12.dp),
    ) {
        Text(user.name, style = MaterialTheme.typography.titleSmall)
        Text(
            user.email,
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
        )
    }
}
