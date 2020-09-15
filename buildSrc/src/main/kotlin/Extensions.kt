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

import constants.Plugins
import constants.Versions
import org.gradle.api.Project
import org.gradle.api.artifacts.dsl.RepositoryHandler
import org.gradle.kotlin.dsl.apply
import org.gradle.plugin.use.PluginDependenciesSpec
import org.gradle.plugin.use.PluginDependencySpec

// Android Application Plugin Dependency Extension -------------------------------------------------
val PluginDependenciesSpec.androidApplication: PluginDependencySpec
    get() = id(Plugins.ANDROID_APPLICATION)

// Module Plugin Dependency Extensions -------------------------------------------------------------
val PluginDependenciesSpec.appGradlePlugin: PluginDependencySpec
    get() = id(Plugins.APP_GRADLE_PLUGIN)

// Static Analyzer Plugin Dependency Extensions ----------------------------------------------------
// DependencyUpdate
val PluginDependenciesSpec.applyUpdate: PluginDependencySpec
    get() = id(Plugins.UPDATE).version(Versions.UPDATE)

// Ktlint
val PluginDependenciesSpec.applyKtlint: PluginDependencySpec
    get() = id(Plugins.KTLINT).version(Versions.KTLINT)

val Project.addKtlint
    get() = apply(plugin = Plugins.KTLINT)

// Detekt
val PluginDependenciesSpec.applyDetekt: PluginDependencySpec
    get() = id(Plugins.DETEKT).version(Versions.DETEKT)

val Project.addDetekt
    get() = apply(plugin = Plugins.DETEKT)

// Repository Handler Extensions -------------------------------------------------------------------
fun RepositoryHandler.applyDefault() {
    google() // Android plugin & support libraries
    jcenter() // Main open-source repository
    gradlePluginPortal() // Gradle plugin repository
    maven("https://dl.bintray.com/kotlin/kotlin-eap")
    maven("https://oss.sonatype.org/content/repositories/snapshots/")
}

fun RepositoryHandler.maven(url: String) {
    maven {
        setUrl(url)
    }
}
