plugins {
    kotlin("jvm") version "1.8.10"
    id("com.projectronin.demo.plugin") version "1.0.0-SNAPSHOT"
    application
}

kotlin {
    jvmToolchain {
        languageVersion.set(JavaLanguageVersion.of(17))
    }
}

application {
    mainClass.set("MainKt")
}


// Configures an existing Task
listFiles {
    includeSizes.set(true)
}

// Uses an extension to call a function which creates a Task
sourceSizePlugin {
    listSourceSize(sourceSets["main"])
}

dependencies {
    implementation("org.apache.commons:commons-lang3:3.0")
}


tasks.test {
    useJUnitPlatform()
}

allprojects {
    repositories {
        mavenCentral()
    }
}
