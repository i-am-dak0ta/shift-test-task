plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    id("android-base-convention")
    id("kotlin-serialization-convention")
}

android {
    namespace = "com.dak0ta.shift.feature.user.impl"
}

dependencies {

    implementation(libs.koin.core)

    implementation(project(":user:api"))
    implementation(project(":coroutine"))
    implementation(project(":network"))
    implementation(project(":database"))
}