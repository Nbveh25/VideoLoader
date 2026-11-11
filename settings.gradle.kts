pluginManagement {
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
plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "1.0.0"
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "VideoLoader"
include(":app")
// Core.
include(":core:common")
include(":core:network")
include(":core:database")
include(":core:upload")
// Features.
include(":feature:library:api")
include(":feature:library:impl")
include(":feature:uploads:api")
include(":feature:uploads:impl")
