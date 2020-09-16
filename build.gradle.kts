/*
 * Copyright 2020 timtb.dev
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

// Top-level build file where you can add configuration options common to all sub-projects/modules.
import constants.TaskGroups
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.jlleitschuh.gradle.ktlint.reporter.ReporterType

plugins {
    applyUpdate
    applyKtlint
    applyDetekt
}

buildscript {
    val kotlin_version by extra("1.4.10")
    repositories.applyDefault()
    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlin_version")
    }
}

allprojects {
    repositories.applyDefault()

    tasks.withType<KotlinCompile> {
        kotlinOptions.jvmTarget = JavaVersion.VERSION_1_8.toString()
    }
}

subprojects {

    addKtlint
    ktlint {
        debug.set(true)
        verbose.set(true)
        outputColorName.set("RED")
        enableExperimentalRules.set(true)
        disabledRules.set(setOf("final-newline"))
        reporters {
            reporter(ReporterType.CHECKSTYLE)
        }
        filter {
            exclude("**/generated/**")
        }
    }

    addDetekt
    detekt {
        parallel = true
    }
}

tasks {
    withType<com.github.benmanes.gradle.versions.updates.DependencyUpdatesTask> {
        resolutionStrategy {
            componentSelection {
                all {
                    val rejected = listOf("alpha", "beta", "rc", "cr", "m", "preview", "b", "ea")
                        .map { qualifier -> Regex("(?i).*[.-]$qualifier[.\\d-+]*") }
                        .any { it.matches(candidate.version) }

                    if (rejected) {
                        reject("Release candidate")
                    }
                }
            }
        }
    }
}

tasks {
    register<Copy>("copyGitHooks") {
        description = "Copies the git hooks from scripts/git-hooks to the .git folder."
        group = TaskGroups.GIT_HOOKS
        from("$rootDir/scripts/git-hooks/") {
            include("**/*.sh")
            rename("(.*).sh", "$1")
        }
        into("$rootDir/.git/hooks")
    }

    register<Exec>("installGitHooks") {
        description = "Installs the pre-commit git hooks from scripts/git-hooks."
        group = TaskGroups.GIT_HOOKS
        workingDir(rootDir)
        commandLine("chmod")
        args("-R", "+x", ".git/hooks/")
        dependsOn(named("copyGitHooks"))
        onlyIf {
            isLinuxOrMacOs()
        }
        doLast {
            logger.info("Git hooks installed successfully.")
        }
    }

    register<Delete>("deleteGitHooks") {
        description = "Delete the pre-commit git hooks."
        group = TaskGroups.GIT_HOOKS
        delete(fileTree(".git/hooks/"))
    }

    afterEvaluate {
        tasks["Clean"].dependsOn(tasks.named("installGitHooks"))
    }
}

tasks.register("Clean", Delete::class) {
    delete(rootProject.buildDir)
}

fun isLinuxOrMacOs(): Boolean {
    val osName = System.getProperty("os.name").toLowerCase(java.util.Locale.ROOT)
    return listOf("linux", "mac os", "macos").contains(osName)
}
