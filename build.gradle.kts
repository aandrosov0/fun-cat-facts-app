plugins {
    kotlin("jvm") version "2.0.0" apply false
    kotlin("kapt") version "2.0.0" apply false
    kotlin("android") version "2.0.0" apply false
    kotlin("plugin.compose") version "2.0.0" apply false

    id("com.android.library") version "8.5.0" apply false
    id("com.android.application") version "8.5.0" apply false
    id("com.google.dagger.hilt.android") version "2.51.1" apply false
}