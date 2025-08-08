import com.android.build.api.variant.impl.VariantOutputImpl
import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    id("base-convention")
}

val javaVersion: String by project
val vrsCode: String by project
val vrsName: String by project
val appNameFile: String by project

android {
    namespace = "com.dak0ta.shift.app"
    compileSdk = libs.versions.compileSdk.get().toInt()

    defaultConfig {
        applicationId = "com.dak0ta.shift.app"
        minSdk = libs.versions.minSdk.get().toInt()
        targetSdk = libs.versions.targetSdk.get().toInt()
        versionCode = vrsCode.toInt()
        versionName = vrsName
    }

    compileOptions {
        sourceCompatibility = JavaVersion.toVersion(javaVersion)
        targetCompatibility = JavaVersion.toVersion(javaVersion)
    }
    buildFeatures {
        compose = true
    }
}

kotlin {
    compilerOptions {
        jvmTarget.set(JvmTarget.JVM_21)
    }
}

androidComponents {
    onVariants { variant ->
        variant.outputs.filterIsInstance<VariantOutputImpl>().forEach { output ->
            output.outputFileName.set(
                "$appNameFile-${variant.buildType}-$vrsName-$vrsCode.apk"
            )
        }
    }
}

dependencies {
    implementation(project(":coroutine"))
    implementation(project(":network"))
    implementation(project(":mvvm"))
    implementation(project(":navigation"))
    implementation(project(":database"))
    implementation(project(":user:api"))
    implementation(project(":user:impl"))
    implementation(project(":user:presentation"))

    // Koin
    implementation(platform(libs.koin.bom))
    implementation(libs.koin.core)
    implementation(libs.koin.android)
    implementation(libs.koin.androidx.compose)
    implementation(libs.koin.androidx.compose.navigation)

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
}
