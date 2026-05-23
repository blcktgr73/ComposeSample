package com.palab.composesample.lessons.step6_hybrid

import android.annotation.SuppressLint
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import com.palab.composesample.ui.components.LessonScaffold

@SuppressLint("SetJavaScriptEnabled")
@Composable
fun WebViewScreen(onBack: () -> Unit) {
    LessonScaffold(
        title = "STEP 6 · Hybrid UI",
        hint = "factory 로 View 생성, update 로 상태(url)를 반영. Compose 는 '얹는' 구조.",
        onBack = onBack,
    ) { padding ->
        var inputUrl by remember { mutableStateOf("https://developer.android.com/jetpack/compose") }
        var loadedUrl by remember { mutableStateOf(inputUrl) }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding),
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp),
            ) {
                OutlinedTextField(
                    value = inputUrl,
                    onValueChange = { inputUrl = it },
                    label = { Text("URL") },
                    singleLine = true,
                    modifier = Modifier.fillMaxWidth(),
                )
                Button(
                    onClick = { loadedUrl = inputUrl },
                    modifier = Modifier.fillMaxWidth(),
                ) {
                    Text("이동")
                }
            }

            AndroidView(
                modifier = Modifier.fillMaxSize(),
                factory = { context ->
                    WebView(context).apply {
                        webViewClient = WebViewClient()
                        settings.javaScriptEnabled = true
                    }
                },
                update = { webView ->
                    // Compose state(loadedUrl) → AndroidView 반영 지점
                    if (webView.url != loadedUrl) {
                        webView.loadUrl(loadedUrl)
                    }
                },
            )
        }
    }
}
