package com.example.gradlepluginbuildsrc

import org.gradle.api.Plugin
import org.gradle.api.Project

@SuppressWarnings("GroovyUnusedDeclaration")
public class ChangeReadMeVersionPlugin implements Plugin<Project> {

    @Override
    void apply(Project project){
        project.extensions.create('changeReadMeVersion', VersionPluginExtension)

        project.afterEvaluate {
            project.task('changeVersion', type: ChangeVersion) {
                readMe = new File(project.rootDir.absolutePath + "/README.md")
                versionName = project.android.defaultConfig.versionName
                overrideContent = project?.changeReadMeVersion?.overrideContent
            }

            project.task('displayVersion', type: DisplayVersion) {
                versionName = project.android.defaultConfig.versionName
            }
        }
    }
}