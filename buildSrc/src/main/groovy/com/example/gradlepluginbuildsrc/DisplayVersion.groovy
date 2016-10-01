package com.example.gradlepluginbuildsrc

import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction

@SuppressWarnings("GroovyUnusedDeclaration")
public class DisplayVersion extends DefaultTask {

    def versionName

    DisplayVersion() {
        group = 'my gradle plugin'
    }

    @TaskAction
    def display() {
        description = 'Print the version info'
        println "Version: ${versionName}"
    }
}