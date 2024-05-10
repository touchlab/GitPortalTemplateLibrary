plugins {
    kotlin("multiplatform") version kmpLibs.versions.kotlin.get() apply false
    kotlin("plugin.serialization") version kmpLibs.versions.kotlin.get() apply false
    alias(kmpLibs.plugins.android.library) apply false
    alias(kmpLibs.plugins.sqldelight) apply false
    alias(kmpLibs.plugins.skie) apply false
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
