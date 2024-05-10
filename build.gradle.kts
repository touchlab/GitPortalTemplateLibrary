plugins {
    kotlin("multiplatform") version kmpLibs.versions.kotlin.get() apply false
    kotlin("plugin.serialization") version kmpLibs.versions.kotlin.get() apply false
    id("com.android.library") version kmpLibs.versions.android.gradle.plugin.get() apply false
    id("app.cash.sqldelight") version kmpLibs.versions.sqlDelight.get() apply false
    id("co.touchlab.skie") version kmpLibs.versions.skie.get() apply false
}

allprojects {
    repositories {
        google()
        mavenCentral()
    }
}

subprojects {
    val VERSION_NAME: String by project
    val GROUP: String by project
    group = GROUP
    version = VERSION_NAME
}

tasks.register<Delete>("clean") {
    delete(rootProject.buildDir)
}
