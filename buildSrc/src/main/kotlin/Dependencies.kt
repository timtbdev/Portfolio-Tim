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

/**
 * Interface for Jetpack components
 * */
interface JetpackComponents {
    val dependencies: List<String>
    val kapts: List<String>
    val tests: List<String>
}

/**
 * Interface for dependencies + tests
 * */
interface Libraries {
    val dependencies: List<String>
    val tests: List<String>
}

/**
 * Interface only for dependencies
 * */
interface OnlyLibraries {
    val dependencies: List<String>
}

/**
 * Dependencies
 * */
object Deps {

    /**
     * Kotlin -------------------------------------------------------------------------------------
     * */
    object Kotlin : Libraries {
        object Versions {
            const val KOTLIN = "1.4.0"
        }

        object Libs {
            const val KOTLIN = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:"
            const val KOTLIN_JUNIT = "org.jetbrains.kotlin:kotlin-test-junit:"
        }

        // Dependencies
        const val KOTLIN = Libs.KOTLIN + Versions.KOTLIN

        // Tests
        const val KOTLIN_JUNIT = Libs.KOTLIN_JUNIT + Versions.KOTLIN

        override val dependencies: List<String>
            get() = listOf(KOTLIN)

        override val tests: List<String>
            get() = listOf(KOTLIN_JUNIT)
    }

    /**
     * Kotlin Coroutines --------------------------------------------------------------------------
     * */
    object KotlinCoroutines : Libraries {

        object Versions {
            const val KOTLIN_COROUTINES = "1.3.9"
        }

        object Libs {
            const val KOTLIN_COROUTINES = "org.jetbrains.kotlinx:kotlinx-coroutines-core:"
            const val KOTLIN_COROUTINES_ANDROID =
                "org.jetbrains.kotlinx:kotlinx-coroutines-android:"
            const val KOTLIN_COROUTINES_TEST = "org.jetbrains.kotlinx:kotlinx-coroutines-test:"
        }

        // Dependencies
        const val KOTLIN_COROUTINES = Libs.KOTLIN_COROUTINES + Versions.KOTLIN_COROUTINES
        const val KOTLIN_COROUTINES_ANDROID =
            Libs.KOTLIN_COROUTINES_ANDROID + Versions.KOTLIN_COROUTINES
        const val KOTLIN_COROUTINES_TEST = Libs.KOTLIN_COROUTINES_TEST + Versions.KOTLIN_COROUTINES

        override val dependencies: List<String>
            get() = listOf(
                KOTLIN_COROUTINES,
                KOTLIN_COROUTINES_ANDROID
            )
        override val tests: List<String>
            get() = listOf(
                KOTLIN_COROUTINES_TEST
            )

    }

    /**
     * Androidx Jetpack ---------------------------------------------------------------------------
     * */
    object Androidx : JetpackComponents {

        object Versions {
            const val ANDROIDX_CORE_KTX = "1.3.0"
            const val ANDROIDX_ARCH_TEST = "2.1.0"
            const val ANDROIDX_APP_COMPAT = "1.1.0"
            const val FRAGMENT = "1.2.5"
            const val LIFECYCLE = "2.2.0"
            const val NAVIGATION = "2.3.0"
            const val ROOM = "2.3.0-alpha02"
            const val WORK = "2.4.0"
            const val PAGING = "3.0.0-alpha03"
            const val HILT = "2.28.3-alpha"
            const val MATERIAL_DESIGN = "1.3.0-alpha02"
            const val CONSTRAINT_LAYOUT = "2.0.0-rc1"
            const val SWIPE_REFRESH_LAYOUT = "1.1.0"
            const val VIEW_PAGER = "1.0.0"
            const val RECYCLER_VIEW = "1.1.0"
            const val RECYCLER_VIEW_SELECTION = "1.1.0-rc01"
            const val VECTOR_DRAWABLE = "1.2.0-alpha01"
            const val VECTOR_DRAWABLE_ANIMATED = "1.1.0"
            const val PREFERENCE = "1.1.1"
            const val APP_STARTUP = "1.0.0-alpha02"
            const val BROWSER = "1.2.0"
            const val GOOGLE_PLAY_CORE_KTX = "1.8.0"
        }

        object Libs {
            const val ANDROIDX_CORE_KTX = "androidx.core:core-ktx:"
            const val ANDROIDX_CORE_TEST = "androidx.arch.core:core-testing:"
            const val ANDROIDX_APP_COMPAT = "androidx.appcompat:appcompat:"

            // Fragment
            const val ANDROIDX_FRAGMENT_KTX = "androidx.fragment:fragment-ktx:"
            const val ANDROIDX_FRAGMENT_TEST = "androidx.fragment:fragment-testing:"

            // ViewModel
            const val VIEWMODEL_KTX = "androidx.lifecycle:lifecycle-viewmodel-ktx:"
            const val VIEWMODEL_SAVED_STATE = "androidx.lifecycle:lifecycle-viewmodel-savedstate:"

            // Live Data
            const val LIVE_DATA_KTX = "androidx.lifecycle:lifecycle-livedata-ktx:"
            const val LIVE_DATA_KAPT = "androidx.lifecycle:lifecycle-compiler:"

            // Navigation
            const val NAV_FRAGMENT_KTX = "androidx.navigation:navigation-fragment-ktx:"
            const val NAV_UI_KTX = "androidx.navigation:navigation-ui-ktx:"
            const val NAV_DYNAMIC = "androidx.navigation:navigation-dynamic-features-fragment:"
            const val NAV_TEST = "androidx.navigation:navigation-testing:"

            // Room
            const val ROOM_RUNTIME = "androidx.room:room-runtime:"
            const val ROOM_KTX = "androidx.room:room-ktx:"
            const val ROOM_KAPT = "androidx.room:room-compiler:"
            const val ROOM_TEST = "androidx.room:room-testing:"

            // WorkManager
            const val WORK_RUNTIME_KTX = "androidx.work:work-runtime-ktx:"
            const val WORK_TEST = "androidx.work:work-testing:"

            // Paging
            const val PAGING_RUNTIME_KTX = "androidx.paging:paging-runtime-ktx:"
            const val PAGING_COMMON = "androidx.paging:paging-common:"

            // Hilt
            const val HILT_ANDROID = "com.google.dagger:hilt-android:"
            const val HILT_KAPT = "com.google.dagger:hilt-android-compiler:"

            // UI
            const val MATERIAL_DESIGN = "com.google.android.material:material:"
            const val CONSTRAINT_LAYOUT = "androidx.constraintlayout:constraintlayout:"
            const val SWIPE_REFRESH_LAYOUT = "androidx.swiperefreshlayout:swiperefreshlayout:"
            const val VIEW_PAGER = "androidx.viewpager2:viewpager2:"
            const val RECYCLER_VIEW_CORE = "androidx.recyclerview:recyclerview:"
            const val RECYCLER_VIEW_SELECTION = "androidx.recyclerview:recyclerview-selection:"
            const val VECTOR_DRAWABLE_CORE = "androidx.vectordrawable:vectordrawable:"
            const val VECTOR_DRAWABLE_ANIMATED = "androidx.vectordrawable:vectordrawable-animated:"

            // Utils
            const val PREFERENCE_KTX = "androidx.preference:preference-ktx:"
            const val APP_STARTUP = "androidx.startup:startup-runtime:"
            const val BROWSER = "androidx.browser:browser:"
            const val GOOGLE_PLAY_CORE_KTX = "com.google.android.play:core-ktx:"
        }

        // Dependencies
        const val ANDROIDX_CORE_KTX = Libs.ANDROIDX_CORE_KTX + Versions.ANDROIDX_CORE_KTX
        const val ANDROIDX_APP_COMPAT = Libs.ANDROIDX_APP_COMPAT + Versions.ANDROIDX_APP_COMPAT

        // Fragment
        const val ANDROIDX_FRAGMENT_KTX = Libs.ANDROIDX_FRAGMENT_KTX + Versions.FRAGMENT

        // ViewModel
        const val VIEW_MODEl_KTX = Libs.VIEWMODEL_KTX + Versions.LIFECYCLE
        const val VIEW_MODEL_SAVED_STATE = Libs.VIEWMODEL_SAVED_STATE + Versions.LIFECYCLE

        // Live Data
        const val LIVE_DATA_KTX = Libs.LIVE_DATA_KTX + Versions.LIFECYCLE

        // Navigation
        const val NAV_FRAGMENT_KTX = Libs.NAV_FRAGMENT_KTX + Versions.NAVIGATION
        const val NAV_UI_KTX = Libs.NAV_UI_KTX + Versions.NAVIGATION
        const val NAV_DYNAMIC = Libs.NAV_DYNAMIC + Versions.NAVIGATION

        // Room
        const val ROOM_RUNTIME = Libs.ROOM_RUNTIME + Versions.ROOM
        const val ROOM_KTX = Libs.ROOM_KTX + Versions.ROOM

        // WorkManager
        const val WORK_RUNTIME_KTX = Libs.WORK_RUNTIME_KTX + Versions.WORK

        // Paging
        const val PAGING_RUNTIME_KTX = Libs.PAGING_RUNTIME_KTX + Versions.PAGING
        const val PAGING_COMMON = Libs.PAGING_COMMON + Versions.PAGING

        // Hilt
        const val HILT_ANDROID = Libs.HILT_ANDROID + Versions.HILT

        // UI
        const val MATERIAL_DESIGN = Libs.MATERIAL_DESIGN + Versions.MATERIAL_DESIGN
        const val CONSTRAINT_LAYOUT = Libs.CONSTRAINT_LAYOUT + Versions.CONSTRAINT_LAYOUT
        const val SWIPE_REFRESH_LAYOUT = Libs.SWIPE_REFRESH_LAYOUT + Versions.SWIPE_REFRESH_LAYOUT
        const val VIEW_PAGER = Libs.VIEW_PAGER + Versions.VIEW_PAGER
        const val RECYCLER_VIEW_CORE = Libs.RECYCLER_VIEW_CORE + Versions.RECYCLER_VIEW
        const val RECYCLER_VIEW_SELECTION =
            Libs.RECYCLER_VIEW_CORE + Versions.RECYCLER_VIEW_SELECTION
        const val VECTOR_DRAWABLE_CORE = Libs.VECTOR_DRAWABLE_CORE + Versions.VECTOR_DRAWABLE
        const val VECTOR_DRAWABLE_ANIMATED =
            Libs.VECTOR_DRAWABLE_ANIMATED + Versions.VECTOR_DRAWABLE_ANIMATED

        // Dynamic feature
        const val GOOGLE_PLAY_CORE_KTX = Libs.GOOGLE_PLAY_CORE_KTX + Versions.GOOGLE_PLAY_CORE_KTX

        // Utils
        const val PREFERENCE_KTX = Libs.PREFERENCE_KTX + Versions.PREFERENCE
        const val APP_STARTUP = Libs.APP_STARTUP + Versions.APP_STARTUP
        const val BROWSER = Libs.BROWSER + Versions.BROWSER

        // Kapt
        const val LIVE_DATA_KAPT = Libs.LIVE_DATA_KAPT + Versions.LIFECYCLE
        const val ROOM_KAPT = Libs.ROOM_KAPT + Versions.ROOM
        const val HILT_KAPT = Libs.HILT_KAPT + Versions.HILT

        // Test
        const val ANDROIDX_CORE_TEST = Libs.ANDROIDX_CORE_TEST + Versions.ANDROIDX_ARCH_TEST
        const val ANDROIDX_FRAGMENT_TEST = Libs.ANDROIDX_FRAGMENT_TEST + Versions.FRAGMENT
        const val NAV_TEST = Libs.NAV_TEST + Versions.NAVIGATION
        const val ROOM_TEST = Libs.ROOM_TEST + Versions.ROOM
        const val WORK_TEST = Libs.WORK_TEST + Versions.WORK

        override val dependencies: List<String>
            get() = listOf(
                ANDROIDX_CORE_KTX,
                ANDROIDX_APP_COMPAT,
                // Fragment
                ANDROIDX_FRAGMENT_KTX,
                // ViewModel
                VIEW_MODEl_KTX,
                VIEW_MODEL_SAVED_STATE,
                // Live Data
                LIVE_DATA_KTX,
                // Navigation
                NAV_FRAGMENT_KTX,
                NAV_UI_KTX,
                NAV_DYNAMIC,
                // Room
                ROOM_RUNTIME,
                ROOM_KTX,
                // WorkManager
                WORK_RUNTIME_KTX,
                // Paging
                PAGING_RUNTIME_KTX,
                PAGING_COMMON,
                // Hilt
                HILT_ANDROID,
                // UI
                MATERIAL_DESIGN,
                CONSTRAINT_LAYOUT,
                SWIPE_REFRESH_LAYOUT,
                VIEW_PAGER,
                RECYCLER_VIEW_CORE,
                RECYCLER_VIEW_SELECTION,
                VECTOR_DRAWABLE_CORE,
                VECTOR_DRAWABLE_ANIMATED,
                // Dynamic feature
                GOOGLE_PLAY_CORE_KTX,
                // Utils
                PREFERENCE_KTX,
                APP_STARTUP,
                BROWSER
            )

        override val kapts: List<String>
            get() = listOf(
                LIVE_DATA_KAPT,
                ROOM_KAPT,
                HILT_KAPT
            )

        override val tests: List<String>
            get() = listOf(
                ANDROIDX_CORE_TEST,
                ANDROIDX_FRAGMENT_TEST,
                NAV_TEST,
                ROOM_TEST,
                WORK_TEST
            )
    }

    /**
     * AndroidX Test dependencies
     * */
    object AndroidxTests : OnlyLibraries {
        object Versions {
            const val ANDROIDX_TEST_CORE = "1.0.0"
            const val ANDROIDX_JUNIT_RULES = "1.1.0"
            const val GOOGLE_TRUTH = "0.42"
            const val ANDROIDX_ESPRESSO = "3.1.0"
        }

        object Libs {
            // AndroidJUnitRunner and JUnit Rules
            const val ANDROIDX_TEST_CORE = "androidx.test:core:"
            const val ANDROIDX_TEST_RUNNER = "androidx.test:runner:"
            const val ANDROIDX_TEST_RULES = "androidx.test:rules:"

            // Assertions
            const val ANDROIDX_TEST_JUNIT_KTX = "androidx.test.ext:junit:"
            const val GOOGLE_TRUTH = "com.google.truth:truth:"
            const val ANDROIDX_TRUTH_KTX = "androidx.test.ext:truth:"

            // UI
            const val ANDROIDX_ESPRESSO_CORE = "androidx.test.espresso:espresso-core:"
            const val ANDROIDX_ESPRESSO_CONTRIB = "androidx.test.espresso:espresso-contrib:"
            const val ANDROIDX_ESPRESSO_IDLING_RESOURCE =
                "androidx.test.espresso:espresso-idling-resource:"
        }

        // AndroidJUnitRunner and JUnit Rules
        const val ANDROIDX_TEST_CORE = Libs.ANDROIDX_TEST_CORE + Versions.ANDROIDX_TEST_CORE
        const val ANDROIDX_TEST_RUNNER = Libs.ANDROIDX_TEST_RUNNER + Versions.ANDROIDX_JUNIT_RULES
        const val ANDROIDX_TEST_RULES = Libs.ANDROIDX_TEST_RULES + Versions.ANDROIDX_JUNIT_RULES

        // Assertions
        const val ANDROIDX_TEST_JUNIT_KTX =
            Libs.ANDROIDX_TEST_JUNIT_KTX + Versions.ANDROIDX_TEST_CORE
        const val GOOGLE_TRUTH = Libs.GOOGLE_TRUTH + Versions.GOOGLE_TRUTH
        const val ANDROIDX_TRUTH_KTX = Libs.ANDROIDX_TRUTH_KTX + Versions.ANDROIDX_TEST_CORE

        // UI
        const val ANDROIDX_ESPRESSO_CORE = Libs.ANDROIDX_ESPRESSO_CORE + Versions.ANDROIDX_ESPRESSO
        const val ANDROIDX_ESPRESSO_CONTRIB =
            Libs.ANDROIDX_ESPRESSO_CONTRIB + Versions.ANDROIDX_ESPRESSO
        const val ANDROIDX_ESPRESSO_IDLING_RESOURCE =
            Libs.ANDROIDX_ESPRESSO_IDLING_RESOURCE + Versions.ANDROIDX_ESPRESSO

        override val dependencies: List<String>
            get() = listOf(
                ANDROIDX_TEST_CORE,
                ANDROIDX_TEST_RUNNER,
                ANDROIDX_TEST_RULES,
                ANDROIDX_TEST_JUNIT_KTX,
                GOOGLE_TRUTH,
                ANDROIDX_TRUTH_KTX,
                ANDROIDX_ESPRESSO_CORE,
                ANDROIDX_ESPRESSO_CONTRIB,
                ANDROIDX_ESPRESSO_IDLING_RESOURCE
            )
    }

    /**
     * Firebase dependencies
     * */
    object Firebase : OnlyLibraries {
        object Versions {
            const val FIREBASE_PERFOFRMANCE = "19.0.8"
            const val FIREBASE_ANALYTICS = "17.4.4"
            const val FIREBASE_CRASHLYTICS = "17.1.1"
        }

        object Libs {
            const val FIREBASE_PERFORMANCE = "com.google.firebase:firebase-perf:"
            const val FIREBASE_ANALYTICS_KTX = "com.google.firebase:firebase-analytics-ktx:"
            const val FIREBASE_CRASHLYTICS = "com.google.firebase:firebase-crashlytics:"
        }

        const val FIREBASE_PERFORMANCE = Libs.FIREBASE_PERFORMANCE + Versions.FIREBASE_PERFOFRMANCE
        const val FIREBASE_ANALYTICS_KTX = Libs.FIREBASE_ANALYTICS_KTX + Versions.FIREBASE_ANALYTICS
        const val FIREBASE_CRASHLYTICS = Libs.FIREBASE_CRASHLYTICS + Versions.FIREBASE_CRASHLYTICS

        override val dependencies: List<String>
            get() = listOf(
                FIREBASE_PERFORMANCE,
                FIREBASE_ANALYTICS_KTX,
                FIREBASE_CRASHLYTICS
            )
    }

    /**
     * Network dependencies
     * */
    object Network : OnlyLibraries {
        object Versions {
            const val RETROFIT = "2.9.0"
            const val OKHTTP = "4.8.0"
            const val COIL = "0.11.0"
            const val GSON = "2.8.6"
        }

        object Libs {
            const val RETROFIT = "com.squareup.retrofit2:retrofit:"
            const val RETROFIT_CONVERTER_GSON = "com.squareup.retrofit2:converter-gson:"
            const val GSON = "com.google.code.gson:gson:"
            const val OKHTTP = "com.squareup.okhttp3:logging-interceptor:"
            const val COIL = "io.coil-kt:coil:"
        }

        // Dependencies
        const val RETROFIT = Libs.RETROFIT + Versions.RETROFIT
        const val RETROFIT_CONVERTER_GSON = Libs.RETROFIT_CONVERTER_GSON + Versions.RETROFIT
        const val GSON = Libs.GSON + Versions.GSON
        const val OKHTTP = Libs.OKHTTP + Versions.OKHTTP
        const val COIL = Libs.COIL + Versions.COIL

        override val dependencies: List<String>
            get() = listOf(
                RETROFIT,
                RETROFIT_CONVERTER_GSON,
                GSON,
                OKHTTP,
                COIL
            )
    }

    /**
     * Utils dependencies
     * */
    object Utils : OnlyLibraries {
        object Versions {
            const val LEAK_CANARY = "2.4"
            const val TIMBER = "4.7.1"
            const val INK_PAGE_INDICATOR = "1.3.0"
        }

        object Libs {
            const val LEAK_CANARY = "com.squareup.leakcanary:leakcanary-android:"
            const val TIMBER = "com.jakewharton.timber:timber:"
            const val INK_PAGE_INDICATOR = "com.pacioianu.david:ink-page-indicator:"
        }

        // Dependencies
        const val LEAK_CANARY = Libs.LEAK_CANARY + Versions.LEAK_CANARY
        const val TIMBER = Libs.TIMBER + Versions.TIMBER
        const val INK_PAGE_INDICATOR = Libs.INK_PAGE_INDICATOR + Versions.INK_PAGE_INDICATOR

        override val dependencies: List<String>
            get() = listOf(
                LEAK_CANARY,
                TIMBER,
                INK_PAGE_INDICATOR
            )
    }

    /**
     * Test Implementations dependencies
     * */
    object Test : OnlyLibraries {
        object Versions {
            const val MOCKK = "1.10.0"
            const val JUNIT_JUPITER = "5.6.0"
            const val JUNIT4 = "4.12"
        }

        object Libs {
            const val JUNIT_JUPITER_API = "org.junit.jupiter:junit-jupiter-api:"
            const val JUNIT_JUPITER_PARAMS = "org.junit.jupiter:junit-jupiter-params:"
            const val JUNIT_JUPITER_ENGINE = "org.junit.jupiter:junit-jupiter-engine:"
            const val MOCKK_CORE = "io.mockk:mockk:"
            const val MOCKK_ANDROID = "io.mockk:mockk-android:"
            const val JUNIT4 = "junit:junit:"
        }

        // Test dependencies
        const val JUPITER_API = Libs.JUNIT_JUPITER_API + Versions.JUNIT_JUPITER
        const val JUPITER_PARAMS = Libs.JUNIT_JUPITER_PARAMS + Versions.JUNIT_JUPITER
        const val JUPITER_ENGINE = Libs.JUNIT_JUPITER_ENGINE + Versions.JUNIT_JUPITER
        const val MOCKK_CORE = Libs.MOCKK_CORE + Versions.MOCKK
        const val MOCKK_ANDROID = Libs.MOCKK_ANDROID + Versions.MOCKK
        const val JUNIT4 = Libs.JUNIT4 + Versions.JUNIT4

        override val dependencies: List<String>
            get() = listOf(
                JUPITER_API,
                JUPITER_PARAMS,
                JUPITER_ENGINE,
                MOCKK_CORE,
                MOCKK_ANDROID,
                JUNIT4
            )

    }
}