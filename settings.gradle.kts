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
        maven(url = "https://jitpack.io")
    }
}

rootProject.name = "Spaces"
include(":app")
include(":benchmark")
include(":features:booking")
include(":data:booking")
include(":core:designsystem")
include(":core:common")
include(":data:property")
