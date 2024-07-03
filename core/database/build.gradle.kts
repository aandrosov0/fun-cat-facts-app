plugins {
    kotlin("android")
    kotlin("kapt")

    id("com.android.library")
}

kotlin {
    jvmToolchain(17)
}

android {
    namespace = "aandrosov.funcatfacts.database"
    compileSdk = 34
}

repositories {
    google()
    mavenCentral()
}

dependencies {
    val roomVersion = "2.6.1"
    val hiltVersion = "2.51.1"

    implementation("androidx.room:room-runtime:$roomVersion")
    annotationProcessor("androidx.room:room-compiler:$roomVersion")
    kapt("androidx.room:room-compiler:$roomVersion")

    implementation(project(":core:data"))

    implementation("com.google.dagger:hilt-android:$hiltVersion")
    kapt("com.google.dagger:hilt-android-compiler:$hiltVersion")
}