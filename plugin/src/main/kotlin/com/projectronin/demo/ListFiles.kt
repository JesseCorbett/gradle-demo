package com.projectronin.demo

import org.gradle.api.DefaultTask
import org.gradle.api.provider.Property
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.OutputFile
import org.gradle.api.tasks.SourceSetContainer
import org.gradle.api.tasks.TaskAction
import org.gradle.language.base.plugins.LifecycleBasePlugin
import java.io.File

/**
 * The configuration container the plugin user will interact with
 */
interface ListFilesExtension {
    val includeSizes: Property<Boolean>
}

/**
 * The class constituting our listFiles task
 */
abstract class ListFilesTask : DefaultTask() {

    /**
     * Gradle requires we annotate task I/O and use this [Property] type
     */
    @get:Input
    abstract val includeSizes: Property<Boolean>

    @get:OutputFile
    val fileOutput: File = project.file(project.layout.buildDirectory.file("file-count.txt"))

    init {
        description = "Lists all files"
        group = LifecycleBasePlugin.VERIFICATION_GROUP
    }

    @TaskAction
    fun listFileSizes() {
        val sourceSets = project.properties["sourceSets"] as SourceSetContainer

        val output = sourceSets.flatMap { sourceSet ->
            sourceSet.allSource.files.map { file ->
                val sizeBytes = if (includeSizes.get())
                    " ${file.length()}b"
                else
                    ""
                file.name + sizeBytes
            }
        }.joinToString("\n")

        fileOutput.writeText(output)
    }
}
