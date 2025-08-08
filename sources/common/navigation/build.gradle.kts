import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    id("base-convention")
    id("java-library")
    alias(libs.plugins.jetbrains.kotlin.jvm)
}

val javaVersion: String by project

java {
    sourceCompatibility = JavaVersion.toVersion(javaVersion)
    targetCompatibility = JavaVersion.toVersion(javaVersion)
}

kotlin {
    compilerOptions {
        jvmTarget.set(JvmTarget.JVM_21)
    }
}

dependencies {
    api(libs.androidx.navigation.compose)
}
