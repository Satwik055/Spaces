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
include(":features:explore")
include(":features:detail")
include(":core:datastore")
include(":features:location")
include(":features:auth")
include(":data:auth")
include(":features:search")
include(":data:payment")
include(":features:checkout")
