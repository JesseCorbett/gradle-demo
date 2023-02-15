package com.projectronin.demo

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.create
import org.gradle.kotlin.dsl.register

/**
 * The class constituting the plugin, what is actually passed via the plugin block
 */
class DemoPlugin : Plugin<Project> {
    override fun apply(project: Project) {
        val configExtension = project.extensions.create<ListFilesExtension>("listFiles").apply {
            includeSizes.convention(false)

        }

        project.tasks.register<ListFilesTask>("listFiles") {
            includeSizes.set(configExtension.includeSizes)
        }
    }
}
