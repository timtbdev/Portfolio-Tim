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

gradlePlugin {
    plugins {
        register("app-gradle-plugin") {
            id = "app-gradle-plugin"
            implementationClass = "plugins.AppGradlePlugin"
        }
        register("cache-gradle-plugin") {
            id = "cache-gradle-plugin"
            implementationClass = "plugins.CacheGradlePlugin"
        }
    }
}

object Versions {
    const val GRADLE = "4.2.0-alpha10"
    const val KOTLIN = "1.4.10"
    const val GOOGLE = "4.3.3"
    const val NAVIGATION = "2.3.0"
    const val PERFORMANCE = "1.3.1"
    const val CRASHLYTICS = "2.2.0"
    const val HILT = "2.28.3-alpha"
}

object Plugins {
    const val GRADLE = "com.android.tools.build:gradle:"
    const val KOTLIN = "gradle-plugin"
    const val GOOGLE = "com.google.gms:google-services:"
    const val NAVIGATION = "androidx.navigation:navigation-safe-args-gradle-plugin:"
    const val PERFORMANCE = "com.google.firebase:perf-plugin:"
    const val CRASHLYTICS = "com.google.firebase:firebase-crashlytics-gradle:"
    const val HILT = "com.google.dagger:hilt-android-gradle-plugin:"
}

object Libs {
    const val GRADLE = Plugins.GRADLE + Versions.GRADLE
    const val GOOGLE = Plugins.GOOGLE + Versions.GOOGLE
    const val NAVIGATION = Plugins.NAVIGATION + Versions.NAVIGATION
    const val PERFORMANCE = Plugins.PERFORMANCE + Versions.PERFORMANCE
    const val CRASHLYTICS = Plugins.CRASHLYTICS + Versions.CRASHLYTICS
    const val HILT = Plugins.HILT + Versions.HILT
}

dependencies {
    implementation(Libs.GRADLE)
    implementation(kotlin(Plugins.KOTLIN, Versions.KOTLIN))
    implementation(Libs.GOOGLE)
    implementation(Libs.NAVIGATION)
    implementation(Libs.PERFORMANCE)
    implementation(Libs.CRASHLYTICS)
    implementation(Libs.HILT)
}