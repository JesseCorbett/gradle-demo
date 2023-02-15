@Suppress("DSL_SCOPE_VIOLATION") // because the linter is unhappy about plugins owning the libs
plugins {
    alias(libs.plugins.kotlin)
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


tasks.test {
    useJUnitPlatform()
}

allprojects {
    repositories {
        mavenCentral()
    }
}
