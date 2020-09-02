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

import com.android.build.gradle.internal.dsl.ProductFlavor
import org.gradle.api.NamedDomainObjectContainer

/** Plugins ------------------------------------------------------------------------------------ */
object Plugins {
    // Top level plugins
    const val ANDROID_APPLICATION: String = "com.android.application"
    const val UPDATE: String = "plugins.update"
    const val KTLINT: String = "plugins.ktlint"
    const val DETEKT: String = "plugins.detekt"
    const val SPOTLESS: String = "plugins.spotless"
    const val GITHOOKS: String = "plugins.githooks"

    // Module plugins
    const val KOTLIN_ANDROID = "kotlin-android"
    const val KOTLIN_ANDROID_EXTENSIONS = "kotlin-android-extensions"
    const val KOTLIN_KAPT = "kotlin-kapt"
    const val GOOGLE: String = "com.google.gms.google-services"
    const val FIREBASE_CRASHLYTICS: String = "com.google.firebase.crashlytics"
    const val FIREBASE_PERFORMANCE: String = "com.google.firebase.firebase-perf"
    const val NAVIGATION: String = "androidx.navigation.safeargs.kotlin"
    const val HILT: String = "dagger.hilt.android.plugin"
}

/** Build -------------------------------------------------------------------------------------- */
object Build {
    const val MIN_SDK: Int = 21
    const val TARGET_SDK: Int = 30
    const val COMPILE_SDK: Int = 30
    const val BUILD_TOOLS: String = "30.0.0"
    const val ANDROID_JUNIT_RUNNER: String = "androidx.test.runner.AndroidJUnitRunner"

    object App {
        const val ID: String = "timtb.portfolio"
        const val VERSION_CODE: Int = 1
        const val VERSION_NAME: String = "1.0.0.0"
    }
}

/** BuildTypes --------------------------------------------------------------------------------- */
interface BuildTypes {

    companion object {
        const val DEBUG = "debug"
        const val RELEASE = "release"
    }

    val isMinifyEnabled: Boolean
    val isCrashlyticsEnabled: Boolean
    val isTestCoverageEnabled: Boolean
    val isDebuggable: Boolean
}

object BuildTypeDebug : BuildTypes {
    override val isMinifyEnabled = false
    override val isCrashlyticsEnabled = false
    override val isTestCoverageEnabled = true
    override val isDebuggable = true
}

object BuildTypeRelease : BuildTypes {
    override val isMinifyEnabled = true
    override val isCrashlyticsEnabled = true
    override val isTestCoverageEnabled = false
    override val isDebuggable = false
    const val isShrinkResources = true
}

/** Product Flavors ---------------------------------------------------------------------------- */
object ProductDimensions {
    const val ENVIRONMENT = "environment"
}

interface ProductFlavors {
    val name: String
    fun libraryCreate(namedDomainObjectContainer: NamedDomainObjectContainer<ProductFlavor>): ProductFlavor
    fun appCreate(namedDomainObjectContainer: NamedDomainObjectContainer<ProductFlavor>): ProductFlavor
}

object ProductFlavorDevelop : ProductFlavors {
    override val name = "dev"
    override fun appCreate(namedDomainObjectContainer: NamedDomainObjectContainer<ProductFlavor>): ProductFlavor {
        return namedDomainObjectContainer.create(name) {
            dimension = ProductDimensions.ENVIRONMENT
            resConfigs("en", "hdpi")
            applicationIdSuffix = ".dev"
            versionNameSuffix = "-dev"
        }
    }

    override fun libraryCreate(namedDomainObjectContainer: NamedDomainObjectContainer<ProductFlavor>): ProductFlavor {
        return namedDomainObjectContainer.create(name) {
            versionNameSuffix = "-dev"
            dimension = ProductDimensions.ENVIRONMENT
        }
    }
}

object ProductFlavorProduction : ProductFlavors {
    override val name = "prod"
    override fun appCreate(namedDomainObjectContainer: NamedDomainObjectContainer<ProductFlavor>): ProductFlavor {
        return namedDomainObjectContainer.create(name) {
            dimension = ProductDimensions.ENVIRONMENT
        }
    }

    override fun libraryCreate(namedDomainObjectContainer: NamedDomainObjectContainer<ProductFlavor>): ProductFlavor {
        return namedDomainObjectContainer.create(name) {
            dimension = ProductDimensions.ENVIRONMENT
        }
    }
}

/** Modules ------------------------------------------------------------------------------------ */
object Modules {

    const val app = ":app"

    object Features {
        const val onboard = ":onboard"
        const val splash = ":splash"
        const val home = ":home"
        const val portfolio = ":portfolio"
        const val settings = ":settings"
    }

    object Libraries {
        const val core = ":core"
        const val network = ":network"
        const val database = ":database"
        const val webservice = ":webservice"
    }

    object Common {
        const val UI = "commons:ui"
        const val VIEWS = "commons:view"
    }
}

/** ProGuards ---------------------------------------------------------------------------------- */
object ProGuards {
    const val RETROFIT = "/settings/proguard_files/proguard-square-retrofit.pro"
    const val GSON = "/settings/proguard_files/proguard-gson.pro"
    const val ANDROID = "proguard-rules.pro"
    const val TXT = "proguard-android-optimize.txt"
}

/** Resources ---------------------------------------------------------------------------------- */
object Resources {

    object App {
        val javaDirs = arrayListOf("src/main/kotlin")
        val resDirs = arrayListOf("src/main/res")
        const val testDir = "src/test/kotlin"
        const val androidTestDir = "src/androidTest/kotlin"
    }

    object Domain {
        val javaDirs = arrayListOf("src/main/kotlin")
        val resDirs = arrayListOf("src/main/res")
        const val testDir = "src/test/kotlin"
        const val androidTestDir = "src/androidTest/kotlin"
    }
}

/** TaskGroups --------------------------------------------------------------------------------- */
object TaskGroups {
    const val ANDROID = "android"
    const val BUILD = "build"
    const val BUILD_SETUP = "build setup"
    const val CLEANUP = "cleanup"
    const val DOCUMENTATION = "documentation"
    const val FORMATTING = "formatting"
    const val GIT_HOOKS = "git hooks"
    const val HELP = "help"
    const val INSTALL = "install"
    const val OTHER = "other"
    const val REPORTING = "reporting"
    const val VERIFICATION = "verification"
}









