pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
    }
}
dependencyResolutionManagement {
    defaultLibrariesExtensionName = "kmpLibs"
}
include("breeds", "analytics", "allshared")
