plugins {
    kotlin("jvm")
    kotlin("kapt")

    `java-library`
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("com.google.dagger:hilt-core:2.51.1")
    kapt("com.google.dagger:hilt-compiler:2.51.1")

    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.9.0-RC")

    implementation("com.squareup.retrofit2:retrofit:2.11.0")
    implementation("com.squareup.retrofit2:converter-gson:2.11.0")
}