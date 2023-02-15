rootProject.name = "gradle-demo"
include("plugin")

pluginManagement {
    repositories {
        mavenLocal()
        gradlePluginPortal()
        mavenCentral()
    }
}
