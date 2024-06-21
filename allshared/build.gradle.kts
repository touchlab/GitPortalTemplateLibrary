@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    kotlin("multiplatform")
    alias(kmpLibs.plugins.skie)
}

kotlin {
    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach {
        it.binaries.framework {
            export(project(":analytics"))
            isStatic = true
        }
    }

    sourceSets {
        commonMain {
            dependencies {
                implementation(project(":breeds"))
                api(project(":analytics"))
            }
        }
    }
}