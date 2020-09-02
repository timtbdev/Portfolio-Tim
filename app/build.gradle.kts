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

import Build.App

plugins {
    androidApplication
    kotlinAndroid
    kotlinAndroidExtensions
    kotlinKapt
    googleServices
    firebaseCrashlytics
    firebasePerformance
    navigationSafeArgs
    daggerHilt
}

android {
    compileSdkVersion(Build.COMPILE_SDK)
    buildToolsVersion(Build.BUILD_TOOLS)

    defaultConfig {
        applicationId = App.ID
        minSdkVersion(Build.MIN_SDK)
        targetSdkVersion(Build.TARGET_SDK)
        versionCode = App.VERSION_CODE
        versionName = App.VERSION_NAME
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
            manifestPlaceholders["crashlyticsEnabled"] =
                BuildTypeDebug.isCrashlyticsEnabled
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
            manifestPlaceholders["crashlyticsEnabled"] =
                BuildTypeRelease.isCrashlyticsEnabled
            proguardFiles(ProGuards.RETROFIT)
            proguardFiles(ProGuards.GSON)
            proguardFiles(getDefaultProguardFile(ProGuards.TXT), ProGuards.ANDROID)
        }
    }

    flavorDimensions(ProductDimensions.ENVIRONMENT)
    productFlavors {
        ProductFlavorDevelop.appCreate(this)
        ProductFlavorProduction.appCreate(this)
    }

    applicationVariants.forEach { variant ->
        variant.outputs.forEach { output ->
            val outputImpl = output as com.android.build.gradle.internal.api.BaseVariantOutputImpl
            val project = project.name
            val sep = "_"
            val flavor = variant.flavorName
            val buildType = variant.buildType.name
            val version = variant.versionName

            val newApkName = "$project$sep$flavor$sep$buildType$sep$version.apk"
            outputImpl.outputFileName = newApkName
        }
    }

    buildFeatures {
        viewBinding = true
        buildConfig = true
        dataBinding = true
    }

    androidExtensions {
        isExperimental = true
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

    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_1_8.toString()
    }

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
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    implementAll(Deps.Kotlin.dependencies)
    implementAll(Deps.KotlinCoroutines.dependencies)
    implementAll(Deps.Androidx.dependencies)
    implementAllKapts(Deps.Androidx.kapts)
    implementAllTests(Deps.Androidx.tests)
    implementAll(Deps.Network.dependencies)

}