package com.palab.composesample.lessons.step2_login

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import com.palab.composesample.ui.components.LessonScaffold

@Composable
fun LoginScreen(onBack: () -> Unit) {
    LessonScaffold(
        title = "STEP 2 · Login",
        hint = "버튼을 직접 enable 시키지 않는다. '현재 상태가 조건을 만족하는가'를 선언만 한다.",
        onBack = onBack,
    ) { padding ->
        // state hoisting: 입력 상태는 화면 최상위에서 보관
        var id by remember { mutableStateOf("") }
        var password by remember { mutableStateOf("") }

        // derived state: 두 입력 상태로부터 파생되는 활성화 여부
        val canSubmit: State<Boolean> = remember {
            derivedStateOf { id.isNotBlank() && password.length >= 4 }
        }

        LoginForm(
            id = id,
            password = password,
            canSubmit = canSubmit.value,
            onIdChange = { id = it },
            onPasswordChange = { password = it },
            onSubmit = { /* 학습 샘플: 실제 인증은 STEP 4에서 다룸 */ },
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(24.dp),
        )
    }
}

@Composable
private fun LoginForm(
    id: String,
    password: String,
    canSubmit: Boolean,
    onIdChange: (String) -> Unit,
    onPasswordChange: (String) -> Unit,
    onSubmit: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        OutlinedTextField(
            value = id,
            onValueChange = onIdChange,
            label = { Text("아이디") },
            singleLine = true,
            modifier = Modifier.fillMaxWidth(),
        )
        OutlinedTextField(
            value = password,
            onValueChange = onPasswordChange,
            label = { Text("비밀번호 (4자 이상)") },
            singleLine = true,
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier.fillMaxWidth(),
        )
        Button(
            onClick = onSubmit,
            enabled = canSubmit,
            modifier = Modifier.fillMaxWidth(),
        ) {
            Text("로그인")
        }
        Text(
            text = if (canSubmit) "조건 만족 → 활성화" else "조건 미충족 → 비활성화",
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
        )
    }
}
