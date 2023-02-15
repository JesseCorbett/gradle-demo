package com.projectronin.demo

import org.gradle.api.DefaultTask
import org.gradle.api.Project
import org.gradle.api.provider.Property
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.SourceSet
import org.gradle.api.tasks.TaskAction
import org.gradle.kotlin.dsl.register
import java.io.File
import kotlin.system.exitProcess

/**
 * The class constituting our SourceSize task
 */
abstract class SourceSizeTask : DefaultTask() {

    /**
     * Gradle requires we annotate task I/O and use this [Property] type
     */
    @get:Input
    abstract val source: Property<SourceSet>

    init {
        description = "Prints the total size of a source set"
        group = "demo"
    }

    @TaskAction
    fun listSourceSize() {
        val set = source.get()
        val size = set.allSource.files.map(File::length).sum()
        logger.error(set.name + ": " + size + " bytes")
    }
}

/**
 * The configuration container the plugin user will interact with
 */
abstract class SourceSizeExtension(private val project: Project) {
    /**
     * A function callable within the DSL extension
     */
    fun listSourceSize(sourceSet: SourceSet) {
        project.tasks.register<SourceSizeTask>(sourceSet.name + "Size") {
            source.set(sourceSet)
        }
    }
}
