plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    id("android-base-convention")
}

android {
    namespace = "com.dak0ta.shift.common.network"
}

dependencies {

    implementation(libs.androidx.runtime.android)
    implementation(libs.androidx.lifecycle.viewmodel.android)
}
