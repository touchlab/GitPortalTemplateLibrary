plugins {
    kotlin("multiplatform")
    alias(kmpLibs.plugins.android.library)
}

kotlin {
    androidTarget {
        publishAllLibraryVariants()
    }
    iosX64()
    iosArm64()
    iosSimulatorArm64()

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(kmpLibs.touchlab.stately.concurrency)
            }
        }
    }
}

android {
    compileSdk = kmpLibs.versions.compileSdk.get().toInt()

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    defaultConfig {
        @Suppress("UnstableApiUsage")
        minSdk = kmpLibs.versions.minSdk.get().toInt()
    }
    namespace = "co.touchlab.gitportaltemplate.analytics"
}