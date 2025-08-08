plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    id("android-base-convention")
    id("kotlin-serialization-convention")
}

android {
    namespace = "com.dak0ta.shift.common.network"
}

dependencies {
    api(libs.retrofit)
    api(libs.retrofit2.kotlinx.serialization.converter)
    api(libs.okhttp)
    api(libs.logging.interceptor)

    implementation(libs.koin.core)

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
}
