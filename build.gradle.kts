// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.android.application) apply false
    // AGP 9 부터 built-in Kotlin 이 자동 적용되므로 kotlin-android 는 추가하지 않습니다.
    alias(libs.plugins.kotlin.compose) apply false
}
