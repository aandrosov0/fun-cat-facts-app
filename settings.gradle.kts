pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}

rootProject.name = "Fun Cat Facts"

include(":app", ":core:data", ":core:database")