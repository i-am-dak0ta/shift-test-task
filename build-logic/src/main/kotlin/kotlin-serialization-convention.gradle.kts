import com.dak0ta.shift.app.libs

plugins {
    id("org.jetbrains.kotlin.plugin.serialization")
}

dependencies {
    add("implementation", libs.kotlinx.serialization.json)
}
