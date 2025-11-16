plugins {
    id("com.android.application")
}

android {
    namespace = "com.example.hello"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.hello"
        minSdk = 21
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
        getByName("debug") {
            isDebuggable = true
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
}

repositories {
    google()
    mavenCentral()
}

// Ensure consistent Kotlin stdlib versions to avoid duplicate-class issues
configurations.all {
    resolutionStrategy {
        // Force the Kotlin stdlib family to a single version
        force(
            "org.jetbrains.kotlin:kotlin-stdlib:1.8.10",
            "org.jetbrains.kotlin:kotlin-stdlib-jdk7:1.8.10",
            "org.jetbrains.kotlin:kotlin-stdlib-jdk8:1.8.10"
        )
        eachDependency {
            if (requested.group == "org.jetbrains.kotlin") {
                useVersion("1.8.10")
            }
        }
    }
}

dependencies {
    implementation("androidx.core:core-ktx:1.10.1")
    implementation("androidx.appcompat:appcompat:1.6.1")
}
