plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    id("android-base-convention")
}

android {
    namespace = "com.dak0ta.shift.feature.user"
}
