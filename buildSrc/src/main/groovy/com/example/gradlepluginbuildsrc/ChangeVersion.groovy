package com.example.gradlepluginbuildsrc

import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction

@SuppressWarnings("GroovyUnusedDeclaration")
public class ChangeVersion extends DefaultTask {

    def readMe
    def versionName
    def overrideContent

    ChangeVersion() {
        group = 'my gradle plugin'
    }

    File getReadMe() {
        project.file(readMe)
    }

    @TaskAction
    def change() {
        description = 'Update version info in the readme file'

        File readMeFile = getReadMe()
        String contents = readMeFile.getText('UTF-8')
        contents = contents.replaceAll("${overrideContent}.*", "${overrideContent}${versionName}")
        readMeFile.write(contents, 'UTF-8')
    }

}