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

package plugins

import com.android.build.gradle.BaseExtension
import constants.*
import dependencies.*
import extensions.buildConfigStringField
import extensions.implementAll
import extensions.kaptAll
import extensions.testImplementationAll
import interfaces.BuildTypes
import org.gradle.api.JavaVersion
import org.gradle.api.Project
import org.gradle.kotlin.dsl.apply
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.getByType

internal fun Project.configureAppPlugins() {
    apply(plugin = Plugins.KOTLIN_ANDROID)
    apply(plugin = Plugins.KOTLIN_ANDROID_EXTENSIONS)
    apply(plugin = Plugins.KOTLIN_KAPT)
    apply(plugin = Plugins.NAVIGATION)
    apply(plugin = Plugins.HILT)
    apply(plugin = Plugins.GOOGLE)
    apply(plugin = Plugins.FIREBASE_CRASHLYTICS)
    apply(plugin = Plugins.FIREBASE_PERFORMANCE)
}

private typealias AndroidBaseExtension = BaseExtension

internal fun Project.configureAndroidApp() = this.extensions.getByType<AndroidBaseExtension>().run {

    compileSdkVersion(Build.COMPILE_SDK)
    buildToolsVersion(Build.BUILD_TOOLS)

    defaultConfig {
        applicationId = Build.App.ID
        minSdkVersion(Build.MIN_SDK)
        targetSdkVersion(Build.TARGET_SDK)
        versionCode = Build.App.VERSION_CODE
        versionName = Build.App.VERSION_NAME
        vectorDrawables.useSupportLibrary = true
        multiDexEnabled = true

        testInstrumentationRunner = Build.ANDROID_JUNIT_RUNNER
    }

    buildTypes {
        getByName(BuildTypes.DEBUG) {
            buildConfigStringField(
                "API_BASE",
                "http://www.timtb.dev/portfolio/api/"
            )
            buildConfigStringField(
                "IMAGE_URL",
                "http://www.timtb.dev/portfolio/images/"
            )
            isMinifyEnabled = BuildTypeDebug.isMinifyEnabled
            isDebuggable = BuildTypeDebug.isDebuggable
            isTestCoverageEnabled = BuildTypeDebug.isTestCoverageEnabled
            manifestPlaceholders["crashlyticsEnabled"] = BuildTypeDebug.isCrashlyticsEnabled
        }
        getByName(BuildTypes.RELEASE) {
            buildConfigStringField(
                "API_BASE",
                "http://www.timtb.dev/portfolio/api/"
            )
            buildConfigStringField(
                "IMAGE_URL",
                "http://www.timtb.dev/portfolio/images/"
            )
            // Enables code shrinking for the release build type.
            isMinifyEnabled = BuildTypeRelease.isMinifyEnabled
            isDebuggable = BuildTypeRelease.isDebuggable
            isShrinkResources = BuildTypeRelease.isShrinkResources
            manifestPlaceholders["crashlyticsEnabled"] = BuildTypeRelease.isCrashlyticsEnabled
            proguardFiles(ProGuards.RETROFIT)
            proguardFiles(ProGuards.GSON)
            proguardFiles(getDefaultProguardFile(ProGuards.TXT), ProGuards.ANDROID)
        }
    }

    flavorDimensions(ProductDimension.ENVIRONMENT)
    productFlavors {
        ProductFlavorDev.appCreate(this)
        ProductFlavorPro.appCreate(this)
    }

    buildFeatures.viewBinding = true
    buildFeatures.buildConfig = true
    dataBinding.isEnabled = true

    @Suppress("UnstableApiUsage")
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    lintOptions {
        isAbortOnError = false
        isIgnoreWarnings = true
    }

    testOptions {
        unitTests.isIncludeAndroidResources = true
        unitTests.isReturnDefaultValues = true
    }

    sourceSets {
        getByName("main") {
            java.setSrcDirs(Resources.App.javaDirs)
            res.setSrcDirs(Resources.App.resDirs)
        }
        getByName("test") {
            java.srcDir(Resources.App.testDir)
        }
        getByName("androidTest") {
            java.srcDir(Resources.App.androidTestDir)
        }
    }

    packagingOptions {
        exclude("META-INF/DEPENDENCIES")
        exclude("META-INF/LICENSE")
        exclude("META-INF/LICENSE.txt")
        exclude("META-INF/license.txt")
        exclude("META-INF/NOTICE")
        exclude("META-INF/NOTICE.txt")
        exclude("META-INF/notice.txt")
        exclude("META-INF/ASL2.0")
        exclude("META-INF/*.kotlin_module")
    }
}

internal fun Project.configureAppDependencies() = this.dependencies {
    add("implementation", fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    implementAll(Kotlin.dependencies)
    implementAll(Coroutines.dependencies)
    implementAll(Androidx.Modules.app_dependencies)
    implementAll(Di.dependencies)
    implementAll(Firebase.dependencies)
    implementAll(Utils.Modules.app_dependencies)
    kaptAll(Kapts.Modules.app_dependencies)
    testImplementationAll(Kotlin.tests)
    testImplementationAll(Coroutines.tests)
}