pluginManagement {
    repositories {
        google()
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

rootProject.name = "Test"
include(":app")
include(":core:common")
include(":feature:hotel")
include(":feature:rooms")
include(":data")
include(":feature:booking")
include(":feature:confirmation")
