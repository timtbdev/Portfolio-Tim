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

package constants

/** Plugins ------------------------------------------------------------------------------------ */
object Plugins {
    // Static Analyzer Plugins
    const val UPDATE: String = "com.github.ben-manes.versions"
    const val KTLINT: String = "org.jlleitschuh.gradle.ktlint"
    const val DETEKT: String = "io.gitlab.arturbosch.detekt"

    // Top level Plugins
    const val ANDROID_APPLICATION: String = "com.android.application"
    const val ANDROID_LIBRARY = "com.android.library"
    const val KOTLIN = "kotlin"
    const val KOTLIN_ANDROID = "kotlin-android"
    const val KOTLIN_ANDROID_EXTENSIONS = "kotlin-android-extensions"
    const val KOTLIN_KAPT = "kotlin-kapt"
    const val GOOGLE: String = "com.google.gms.google-services"
    const val FIREBASE_CRASHLYTICS: String = "com.google.firebase.crashlytics"
    const val FIREBASE_PERFORMANCE: String = "com.google.firebase.firebase-perf"
    const val NAVIGATION: String = "androidx.navigation.safeargs.kotlin"
    const val HILT: String = "dagger.hilt.android.plugin"

    // Modules Plugins
    const val APP_GRADLE_PLUGIN = "app-gradle-plugin"
    const val CACHE_GRADLE_PLUGIN = "cache-gradle-plugin"
}