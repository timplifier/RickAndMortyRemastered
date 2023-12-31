pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}

enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")
enableFeaturePreview("STABLE_CONFIGURATION_CACHE")
dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
    }

    versionCatalogs {
        create("androidProjectConfig") {
            from(files("gradle/android-project-config.versions.toml"))
        }
        create("projectConfig") {
            from(files("gradle/project-config.versions.toml"))
        }
    }
}

rootProject.name = "RickAndMortyRemastered"
includeBuild("build-logic")
include(":app")
include(":konsist")
include(":core:data", ":core:domain", ":core:presentation")
include(
    ":feature:authentication:data",
    ":feature:authentication:domain",
    ":feature:authentication:presentation"
)
include(
    ":feature:main:data",
    ":feature:main:domain",
    ":feature:main:presentation"
)