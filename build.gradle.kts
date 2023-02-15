@Suppress("DSL_SCOPE_VIOLATION") // because the linter is unhappy about plugins owning the libs
plugins {
    alias(libs.plugins.kotlin)
}

kotlin {
    jvmToolchain {
        languageVersion.set(JavaLanguageVersion.of(17))
    }
}


tasks.test {
    useJUnitPlatform()
}

allprojects {
    repositories {
        mavenCentral()
    }
}
