plugins {
    `kotlin-dsl`
    `maven-publish`
    `java-gradle-plugin`
}

group = "com.projectronin.demo"
version = "1.0.0-SNAPSHOT"

gradlePlugin {
    plugins {
        create("demoPlugin") {
            id = "com.projectronin.demo.plugin"
            implementationClass = "com.projectronin.demo.DemoPlugin"
        }
    }
}
