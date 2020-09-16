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
import constants.ModuleBuildType.*
import constants.ModuleType.AppModule
import constants.ModuleType.CacheModule
import constants.Resources.Default
import dependencies.modules.App
import dependencies.modules.Cache
import extensions.*
import interfaces.BuildTypes
import org.gradle.api.JavaVersion
import org.gradle.api.Project
import org.gradle.kotlin.dsl.apply
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.getByType

// Configure Plugins -------------------------------------------------------------------------------
internal fun Project.configurePlugins(buildType: ModuleBuildType) {

    when (buildType) {
        AppLibrary, FeatureLibrary, AndroidLibrary -> {
            apply(plugin = Plugins.KOTLIN_ANDROID)
            apply(plugin = Plugins.KOTLIN_ANDROID_EXTENSIONS)
            if (buildType == AppLibrary || buildType == FeatureLibrary) {
                apply(plugin = Plugins.NAVIGATION)
                apply(plugin = Plugins.GOOGLE)
                apply(plugin = Plugins.FIREBASE_CRASHLYTICS)
                apply(plugin = Plugins.FIREBASE_PERFORMANCE)
            }
            apply(plugin = Plugins.HILT)
        }
        KotlinLibrary -> {
            apply(plugin = Plugins.KOTLIN)
        }
    }
    apply(plugin = Plugins.KOTLIN_KAPT)
}

// Configure Android -------------------------------------------------------------------------------
private typealias AndroidBaseExtension = BaseExtension

// App Android configuration
internal fun Project.configureAndroid(buildType: ModuleBuildType) =
    this.extensions.getByType<AndroidBaseExtension>().run {

        compileSdkVersion(Build.COMPILE_SDK)
        buildToolsVersion(Build.BUILD_TOOLS)

        defaultConfig {
            if (buildType == AppLibrary) {
                applicationId = Build.App.ID
                versionCode = Build.App.VERSION_CODE
                versionName = Build.App.VERSION_NAME
            }
            minSdkVersion(Build.MIN_SDK)
            targetSdkVersion(Build.TARGET_SDK)
            vectorDrawables.useSupportLibrary = true
            multiDexEnabled = true
            testInstrumentationRunner = Build.ANDROID_JUNIT_RUNNER
        }

        buildTypes {
            getByName(BuildTypes.DEBUG) {
                if (buildType == AppLibrary) {
                    buildConfigStringField(
                        "API_BASE",
                        "http://www.timtb.dev/portfolio/api/"
                    )
                    buildConfigStringField(
                        "IMAGE_URL",
                        "http://www.timtb.dev/portfolio/images/"
                    )
                }
                isMinifyEnabled = BuildTypeDebug.isMinifyEnabled
                isDebuggable = BuildTypeDebug.isDebuggable
                isTestCoverageEnabled = BuildTypeDebug.isTestCoverageEnabled
                manifestPlaceholders["crashlyticsEnabled"] = BuildTypeDebug.isCrashlyticsEnabled
            }
            getByName(BuildTypes.RELEASE) {
                if (buildType == AppLibrary) {
                    buildConfigStringField(
                        "API_BASE",
                        "http://www.timtb.dev/portfolio/api/"
                    )
                    buildConfigStringField(
                        "IMAGE_URL",
                        "http://www.timtb.dev/portfolio/images/"
                    )
                    isShrinkResources = BuildTypeRelease.isShrinkResources
                    proguardFiles(ProGuards.RETROFIT)
                    proguardFiles(ProGuards.GSON)
                    proguardFiles(getDefaultProguardFile(ProGuards.TXT), ProGuards.ANDROID)
                }
                // Enables code shrinking for the release build type.
                isMinifyEnabled = BuildTypeRelease.isMinifyEnabled
                isDebuggable = BuildTypeRelease.isDebuggable
                manifestPlaceholders["crashlyticsEnabled"] = BuildTypeRelease.isCrashlyticsEnabled
            }
        }
        flavorDimensions(ProductDimension.ENVIRONMENT)
        when (buildType) {
            AppLibrary -> {
                productFlavors {
                    ProductFlavorDev.appCreate(this)
                    ProductFlavorPro.appCreate(this)
                }
            }
            else -> {
                productFlavors {
                    ProductFlavorDev.libraryCreate(this)
                    ProductFlavorPro.libraryCreate(this)
                }
            }
        }

        if (buildType == AppLibrary || buildType == FeatureLibrary) {
            buildFeatures.viewBinding = true
            buildFeatures.buildConfig = true
            buildFeatures.compose = true
            dataBinding.isEnabled = true

            composeOptions {
                kotlinCompilerExtensionVersion = Versions.COMPOSE
            }
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
                java.setSrcDirs(Default.javaDirs)
                res.setSrcDirs(Default.resDirs)
            }
            getByName("test") {
                java.srcDir(Default.testDir)
            }
            getByName("androidTest") {
                java.srcDir(Default.androidTestDir)
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

// Configure dependencies --------------------------------------------------------------------------
// App dependencies
internal fun Project.configureDependencies(module: ModuleType) = this.dependencies {
    when (module) {
        AppModule -> {
            add("implementation", fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
            implementAll(App.dependencies)
            kaptAll(App.kapts)
            testImplementationAll(App.tests)
            androidTestImplementationAll(App.androidTests)
        }
        CacheModule -> {
            implementAll(Cache.dependencies)
            kaptAll(Cache.kapts)
            testImplementationAll(Cache.tests)
        }
    }

}