plugins {
    kotlin("kapt")
    kotlin("android")
    kotlin("plugin.compose")

    id("com.android.application")
    id("com.google.dagger.hilt.android")
}

kapt {
    correctErrorTypes = true
}

kotlin {
    jvmToolchain(17)
}

android {
    namespace = "aandrosov.funcatfacts.app"

    compileSdk = 34

    defaultConfig {
        applicationId = "aandrosov.funcatfacts.app"

        minSdk = 29
        targetSdk = 34

        versionCode = 1
        versionName = "1.0"
    }

    buildFeatures {
        compose = true
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = true
            proguardFiles(
                getDefaultProguardFile("proguard-android.txt"),
                "proguard-rules.pro"
            )
        }
    }
}

repositories {
    google()
    mavenCentral()
}

dependencies {
    val hiltVersion = "2.51.1"
    val roomVersion = "2.6.1"

    implementation("androidx.room:room-runtime:$roomVersion")
    implementation("androidx.room:room-ktx:$roomVersion")
    annotationProcessor("androidx.room:room-compiler:$roomVersion")
    kapt("androidx.room:room-compiler:$roomVersion")

    implementation(project(":core:data"))
    implementation(project(":core:database"))

    implementation("com.google.android.material:material:1.12.0")

    implementation(platform("androidx.compose:compose-bom:2024.06.00"))
    implementation("androidx.compose.material3:material3")

    implementation("androidx.compose.ui:ui-tooling-preview")
    debugImplementation("androidx.compose.ui:ui-tooling")

    implementation("androidx.activity:activity-compose:1.9.0")
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.8.2")

    implementation("com.google.dagger:hilt-android:$hiltVersion")
    kapt("com.google.dagger:hilt-android-compiler:$hiltVersion")
}