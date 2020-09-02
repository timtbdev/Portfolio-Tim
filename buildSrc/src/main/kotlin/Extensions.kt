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

import com.android.build.gradle.internal.dsl.BuildType
import org.gradle.api.Project
import org.gradle.api.artifacts.Dependency
import org.gradle.api.artifacts.dsl.DependencyHandler
import org.gradle.api.artifacts.dsl.RepositoryHandler
import org.gradle.kotlin.dsl.apply
import org.gradle.plugin.use.PluginDependenciesSpec
import org.gradle.plugin.use.PluginDependencySpec

/** Plugin Extensions --------------------------------------------------------------------- */

// Android Application Plugin
val PluginDependenciesSpec.androidApplication: PluginDependencySpec
    get() = id(Plugins.ANDROID_APPLICATION)

// Kotlin Plugins
val PluginDependenciesSpec.kotlinAndroid: PluginDependencySpec
    get() = id(Plugins.KOTLIN_ANDROID)

val PluginDependenciesSpec.kotlinAndroidExtensions: PluginDependencySpec
    get() = id(Plugins.KOTLIN_ANDROID_EXTENSIONS)

val PluginDependenciesSpec.kotlinKapt: PluginDependencySpec
    get() = id(Plugins.KOTLIN_KAPT)

// Google Services
val PluginDependenciesSpec.googleServices: PluginDependencySpec
    get() = id(Plugins.GOOGLE)

// Firebase Crashlytics
val PluginDependenciesSpec.firebaseCrashlytics: PluginDependencySpec
    get() = id(Plugins.FIREBASE_CRASHLYTICS)

// Firebase Performance
val PluginDependenciesSpec.firebasePerformance: PluginDependencySpec
    get() = id(Plugins.FIREBASE_PERFORMANCE)

val PluginDependenciesSpec.navigationSafeArgs: PluginDependencySpec
    get() = id(Plugins.NAVIGATION)

val PluginDependenciesSpec.daggerHilt: PluginDependencySpec
    get() = id(Plugins.HILT)

// Static analyzer plugins
val Project.applyUpdate
    get() = apply(plugin = Plugins.UPDATE)

val Project.applySpotless
    get() = apply(plugin = Plugins.SPOTLESS)

val Project.applyKtlint
    get() = apply(plugin = Plugins.KTLINT)

val Project.applyDetekt
    get() = apply(plugin = Plugins.DETEKT)

val Project.applyGitHooks
    get() = apply(plugin = Plugins.GITHOOKS)

/** BuildConfig Extensions --------------------------------------------------------------------- */

/** Adds a new string field to the generated BuildConfig class. */
fun BuildType.buildConfigStringField(name: String, value: String) {
    this.buildConfigField("String", name, "\"$value\"")
}

/** Adds a new integer field to the generated BuildConfig class. */
fun BuildType.buildConfigIntField(name: String, value: Int) {
    this.buildConfigField("int", name, value.toString())
}

/** Adds a new boolean field to the generated BuildConfig class. */
fun BuildType.buildConfigBooleanField(name: String, value: Boolean) {
    this.buildConfigField("boolean", name, value.toString())
}

/** Dependency Extensions ---------------------------------------------------------------------- */

/** Adds a dependency debugImplementation to the configuration. **/
fun DependencyHandler.debugImplementation(dependencyNotation: String): Dependency? =
    add("debugImplementation", dependencyNotation)

/** Adds a dependency implementation to the configuration. **/
fun DependencyHandler.implementation(dependencyNotation: String): Dependency? =
    add("implementation", dependencyNotation)

/** Adds a dependency api to the configuration. **/
fun DependencyHandler.api(dependencyNotation: String): Dependency? =
    add("api", dependencyNotation)

/** Adds a dependency kapt to the configuration. **/
fun DependencyHandler.kapt(dependencyNotation: String): Dependency? =
    add("kapt", dependencyNotation)

/** Adds a dependency testImplementation to the configuration. **/
fun DependencyHandler.testImplementation(dependencyNotation: String): Dependency? =
    add("testImplementation", dependencyNotation)

/** Adds a dependency testRuntimeOnly to the configuration. **/
fun DependencyHandler.testRuntimeOnly(dependencyNotation: String): Dependency? =
    add("testRuntimeOnly", dependencyNotation)

/** Adds a dependency androidTestImplementation to the configuration. **/
fun DependencyHandler.androidTestImplementation(dependencyNotation: String): Dependency? =
    add("androidTestImplementation", dependencyNotation)

/** Adds a list of dependencies implementation to the configuration. **/
fun DependencyHandler.implementAll(list: List<String>) {
    list.forEach {
        add("implementation", it)
    }
}

/** Adds a list of test dependencies implementation to the configuration. **/
fun DependencyHandler.implementAllTests(list: List<String>) {
    list.forEach {
        testImplementation(it)
    }
}

/** Adds a list of test dependencies implementation to the configuration. **/
fun DependencyHandler.implementAllAndroidTests(list: List<String>) {
    list.forEach {
        androidTestImplementation(it)
    }
}

/** Adds a list of test dependencies implementation to the configuration. **/
fun DependencyHandler.implementAllKapts(list: List<String>) {
    list.forEach {
        kapt(it)
    }
}

/** Repository Extensions ---------------------------------------------------------------------- */
fun RepositoryHandler.applyDefault() {
    google()
    jcenter()
    gradlePluginPortal()
    maven("https://dl.bintray.com/kotlin/kotlin-eap")
    maven("https://oss.sonatype.org/content/repositories/snapshots/")
}

fun RepositoryHandler.maven(url: String) {
    maven {
        setUrl(url)
    }
}


