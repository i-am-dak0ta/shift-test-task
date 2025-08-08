rootProject.name = "shift-test-task"

pluginManagement {
    includeBuild("build-logic")
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

listOf(
    "sources/common",
    "sources/feature",
).forEach { folder ->
    val folderFile = file(folder)
    if (folderFile.exists() && folderFile.isDirectory) {
        includeModulesFromDirectory(folderFile)
    }
}

fun includeModulesFromDirectory(directory: File, parentPath: String = "") {
    directory.listFiles()
        ?.filter { it.isDirectory }
        ?.forEach { file ->
            val isModule = file.listFiles()?.any { it.name == "build.gradle" || it.name == "build.gradle.kts" } == true
            val moduleName = if (parentPath.isEmpty()) ":${file.name}" else "$parentPath:${file.name}"
            if (isModule) {
                println("Including $moduleName from $file")
                include(moduleName)
                project(moduleName).projectDir = file
            }
            includeModulesFromDirectory(file, moduleName)
        }
}

include(":app")
