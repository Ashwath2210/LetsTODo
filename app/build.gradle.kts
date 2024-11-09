// build.gradle.kts (App-Level)

plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("kapt") // For Room annotation processing
}

android {
    compileSdk = 33 // Or whatever the latest SDK is

    defaultConfig {
        applicationId = "com.example.letstodotask" // Replace with your app's package name
        minSdk = 21 // Minimum SDK version your app supports
        targetSdk = 33 // Target SDK version your app is optimized for
        versionCode = 1
        versionName = "1.0"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }

    buildFeatures {
        viewBinding = true // If you want to use ViewBinding
    }
}

dependencies {
    // Core Android and Kotlin dependencies
    implementation("androidx.core:core-ktx:1.10.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.9.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")

    // Room database dependencies
    implementation("androidx.room:room-runtime:2.4.3")
    kapt("androidx.room:room-compiler:2.4.3") // Room annotation processor

    // RecyclerView (if you're using RecyclerView for task lists)
    implementation("androidx.recyclerview:recyclerview:1.2.1")

    // Kotlin standard library
    implementation("org.jetbrains.kotlin:kotlin-stdlib:1.7.10")

    // For notifications
    implementation("androidx.work:work-runtime-ktx:2.7.0") // If you want to schedule background tasks for deadlines
}
