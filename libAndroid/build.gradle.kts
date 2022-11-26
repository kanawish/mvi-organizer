plugins {
    kotlin("android")
    id("com.android.library")
}

android {
    compileSdk = 33
    defaultConfig {
        minSdk = 24
        targetSdk = 33
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }
    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    kotlinOptions {
        jvmTarget = "1.8"
        freeCompilerArgs = freeCompilerArgs + "-Xopt-in=kotlin.RequiresOptIn"
    }
}

dependencies {
    api(project(":libCommon"))

    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.4")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.6.4")

    // Simple DI
    implementation("io.insert-koin:koin-android:3.2.0")

    // Square Networking
    implementation ("com.squareup.okhttp3:logging-interceptor:4.9.0") // https://github.com/square/okhttp/blob/master/CHANGELOG.md
    implementation ("com.squareup.retrofit2:retrofit:2.9.0") // https://github.com/square/retrofit/blob/master/CHANGELOG.md
    implementation ("com.squareup.retrofit2:converter-gson:2.9.0")

    // Logging
    implementation("com.jakewharton.timber:timber:4.7.1") // https://github.com/JakeWharton/timber/releases

    // Unit tests
    testImplementation("junit:junit:4.13.2")
    testImplementation("io.insert-koin:koin-test:3.2.0")
    testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.6.4")
    testImplementation("com.squareup.okhttp3:mockwebserver:4.9.3")

    // Instrumentation & UI
    androidTestImplementation("androidx.test.ext:junit:1.1.4")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.0")
}
