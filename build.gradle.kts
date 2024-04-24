plugins {
    kotlin("multiplatform") version libs.versions.kotlin.get() apply false
    kotlin("plugin.serialization") version libs.versions.kotlin.get() apply false
    id("com.android.library") version libs.versions.android.gradle.plugin.get() apply false
    id("app.cash.sqldelight") version libs.versions.sqlDelight.get() apply false
    id("co.touchlab.skie") version libs.versions.skie.get() apply false
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
