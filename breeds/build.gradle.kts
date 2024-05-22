plugins {
    kotlin("multiplatform")
    kotlin("plugin.serialization")
    alias(kmpLibs.plugins.android.library)
    alias(kmpLibs.plugins.sqldelight)
}

kotlin {
    androidTarget {
        publishAllLibraryVariants()
    }
    iosArm64()
    iosX64()
    iosSimulatorArm64()

    sourceSets {
        commonMain {
            dependencies {
                implementation(project(":analytics"))
                implementation(kmpLibs.coroutines.core)
                implementation(kmpLibs.bundles.ktor.common)
                implementation(kmpLibs.multiplatformSettings)
                implementation(kmpLibs.kotlinx.dateTime)
                implementation(kmpLibs.touchlab.kermit)
                implementation(kmpLibs.sqlDelight.coroutinesExt)
            }
        }
        androidMain {
            dependencies {
                implementation(kmpLibs.sqlDelight.android)
                implementation(kmpLibs.ktor.client.okHttp)
            }
        }
        iosMain {
            dependencies {
                implementation(kmpLibs.touchlab.stately.common)
                implementation(kmpLibs.sqlDelight.native)
                implementation(kmpLibs.ktor.client.ios)
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
    namespace = "co.touchlab.gitportaltemplate.breeds"
}

sqldelight {
    databases.create("GitPortalTemplateDb") {
        packageName.set("co.touchlab.gitportaltemplate.db")
    }
}
