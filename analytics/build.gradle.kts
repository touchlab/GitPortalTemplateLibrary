plugins {
    kotlin("multiplatform")
    alias(kmpLibs.plugins.android.library)
}

kotlin {
    @Suppress("OPT_IN_USAGE")
    targetHierarchy.default()
    androidTarget {
        publishAllLibraryVariants()
    }
    ios()
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