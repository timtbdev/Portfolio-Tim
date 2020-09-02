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


import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    `kotlin-dsl`
    `kotlin-dsl-precompiled-script-plugins`
}

repositories {
    google()
    jcenter()
    gradlePluginPortal()
}

val compileKotlin: KotlinCompile by tasks
compileKotlin.kotlinOptions {
    languageVersion = Versions.KOTLIN
}

kotlinDslPluginOptions {
    experimentalWarning.set(false)
}

object Versions {
    const val GRADLE = "4.0.1"
    const val KOTLIN = "1.4.0"
    const val GOOGLE = "4.3.3"
    const val NAVIGATION = "2.3.0"
    const val PERFORMANCE = "1.3.1"
    const val CRASHLYTICS = "2.2.0"
    const val HILT = "2.28.3-alpha"
    const val SPOTLESS = "5.1.1"
    const val KTLINT = "0.38.1"
    const val DETEKT = "1.12.0-RC1"
    const val VERSION_UPDATE = "0.29.0"
}

object Plugins {
    const val GRADLE = "com.android.tools.build:gradle:"
    const val KOTLIN = "gradle-plugin"
    const val GOOGLE = "com.google.gms:google-services:"
    const val NAVIGATION = "androidx.navigation:navigation-safe-args-gradle-plugin:"
    const val PERFORMANCE = "com.google.firebase:perf-plugin:"
    const val CRASHLYTICS = "com.google.firebase:firebase-crashlytics-gradle:"
    const val HILT = "com.google.dagger:hilt-android-gradle-plugin:"
    const val SPOTLESS = "com.diffplug.spotless:spotless-plugin-gradle:"
    const val KTLINT = "com.pinterest:ktlint:"
    const val DETEKT = "io.gitlab.arturbosch.detekt:detekt-gradle-plugin:"
    const val VERSION_UPDATE = "com.github.ben-manes:gradle-versions-plugin:"
}

object Libs {
    const val GRADLE = Plugins.GRADLE + Versions.GRADLE
    const val GOOGLE = Plugins.GOOGLE + Versions.GOOGLE
    const val NAVIGATION = Plugins.NAVIGATION + Versions.NAVIGATION
    const val PERFORMANCE = Plugins.PERFORMANCE + Versions.PERFORMANCE
    const val CRASHLYTICS = Plugins.CRASHLYTICS + Versions.CRASHLYTICS
    const val HILT = Plugins.HILT + Versions.HILT
    const val SPOTLESS = Plugins.SPOTLESS + Versions.SPOTLESS
    const val KTLINT = Plugins.KTLINT + Versions.KTLINT
    const val DETEKT = Plugins.DETEKT + Versions.DETEKT
    const val VERSION_UPDATE = Plugins.VERSION_UPDATE + Versions.VERSION_UPDATE
}

dependencies {
    implementation(Libs.GRADLE)
    implementation(kotlin(Plugins.KOTLIN, Versions.KOTLIN))
    implementation(Libs.GOOGLE)
    implementation(Libs.NAVIGATION)
    implementation(Libs.PERFORMANCE)
    implementation(Libs.CRASHLYTICS)
    implementation(Libs.HILT)
    implementation(Libs.SPOTLESS)
    implementation(Libs.KTLINT)
    implementation(Libs.DETEKT)
    implementation(Libs.VERSION_UPDATE)
}