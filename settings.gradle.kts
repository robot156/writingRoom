pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
        jcenter()
        maven { setUrl("https://jitpack.io") }
        mavenCentral()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        jcenter()
        maven { setUrl("https://jitpack.io") }
        mavenCentral()
    }
}
rootProject.name = "writingRoom"
include(":app")
include(":presentation")
include(":domain")
include(":data")
