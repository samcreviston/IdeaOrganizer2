plugins {
    // Declare plugin versions here but don't apply them to the root project.
    id("com.android.application") version "8.2.2" apply false
    id("org.jetbrains.kotlin.android") version "1.9.22" apply false
}

// Configure repositories for all projects
allprojects {
    repositories {
        google()
        mavenCentral()
    }
}
