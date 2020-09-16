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

object Libs {

    // Kotlin --------------------------------------------------------------------------------------
    const val KOTLIN_STDLIB = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:"
    const val KOTLIN_JUNIT = "org.jetbrains.kotlin:kotlin-test-junit:"

    // Coroutines ----------------------------------------------------------------------------------
    const val COROUTINES_CORE = "org.jetbrains.kotlinx:kotlinx-coroutines-core:"
    const val COROUTINES_ANDROID = "org.jetbrains.kotlinx:kotlinx-coroutines-android:"
    const val COROUTINES_TEST = "org.jetbrains.kotlinx:kotlinx-coroutines-test:"

    // Dependency Injection ------------------------------------------------------------------------
    const val HILT_ANDROID = "com.google.dagger:hilt-android:"
    const val HILT_KAPT = "com.google.dagger:hilt-android-compiler:"

    // AndroidX ------------------------------------------------------------------------------------
    const val CORE_KTX = "androidx.core:core-ktx:"
    const val ARCH_TEST = "androidx.arch.core:core-testing:"
    const val APP_COMPAT = "androidx.appcompat:appcompat:"

    // Fragment
    const val FRAGMENT = "androidx.fragment:fragment-ktx:"
    const val FRAGMENT_TEST = "androidx.fragment:fragment-testing:"

    // ViewModel
    const val VIEW_MODEL = "androidx.lifecycle:lifecycle-viewmodel-ktx:"
    const val VIEW_MODEL_SAVED_STATE = "androidx.lifecycle:lifecycle-viewmodel-savedstate:"

    // Live Data
    const val LIVE_DATA = "androidx.lifecycle:lifecycle-livedata-ktx:"
    const val LIVE_DATA_KAPT = "androidx.lifecycle:lifecycle-compiler:"

    // Navigation
    const val NAV_FRAGMENT = "androidx.navigation:navigation-fragment-ktx:"
    const val NAV_UI_KTX = "androidx.navigation:navigation-ui-ktx:"
    const val NAV_DYNAMIC = "androidx.navigation:navigation-dynamic-features-fragment:"
    const val NAV_TEST = "androidx.navigation:navigation-testing:"

    // Room
    const val ROOM_RUNTIME = "androidx.room:room-runtime:"
    const val ROOM_KTX = "androidx.room:room-ktx:"
    const val ROOM_KAPT = "androidx.room:room-compiler:"
    const val ROOM_TEST = "androidx.room:room-testing:"

    // WorkManager
    const val WORK_RUNTIME = "androidx.work:work-runtime-ktx:"
    const val WORK_TEST = "androidx.work:work-testing:"

    // Paging
    const val PAGING_RUNTIME = "androidx.paging:paging-runtime-ktx:"
    const val PAGING_COMMON = "androidx.paging:paging-common:"

    // UI
    const val MATERIAL_DESIGN = "com.google.android.material:material:"
    const val CONSTRAINT_LAYOUT = "androidx.constraintlayout:constraintlayout:"
    const val SWIPE_REFRESH = "androidx.swiperefreshlayout:swiperefreshlayout:"
    const val VIEW_PAGER = "androidx.viewpager2:viewpager2:"
    const val RV_CORE = "androidx.recyclerview:recyclerview:" // RV = RecyclerView
    const val RV_SELECTION = "androidx.recyclerview:recyclerview-selection:" // RV = RecyclerView
    const val VD_CORE = "androidx.vectordrawable:vectordrawable:" // VD = VectorDrawable
    const val VD_ANIMATED = "androidx.vectordrawable:vectordrawable-animated:"

    // Jetpack Compose
    const val COMPOSE_UI = "androidx.compose.ui:ui:"
    const val COMPOSE_UI_TOOLING = "androidx.ui:ui-tooling:"
    const val COMPOSE_FOUNDATION = "androidx.compose.foundation:foundation:"
    const val COMPOSE_MATERIAL_DESIGN = "androidx.compose.material:material:"
    const val COMPOSE_LIVE_DATA = "androidx.compose.runtime:runtime-livedata:"
    const val COMPOSE_UI_TEST = "androidx.ui:ui-test:"

    // DataStore
    const val DATA_STORE_CORE = "androidx.datastore:datastore-preferences:"
    const val DATA_STORE_PREFERENCE = "androidx.datastore:datastore-core:"


    // Utils
    const val PREFERENCE = "androidx.preference:preference-ktx:"
    const val APP_STARTUP = "androidx.startup:startup-runtime:"
    const val BROWSER = "androidx.browser:browser:"
    const val GOOGLE_PLAY = "com.google.android.play:core-ktx:"

    // AndroidX Tests ------------------------------------------------------------------------------

    // AndroidJUnitRunner and JUnit Rules
    const val TEST_CORE = "androidx.test:core:"
    const val TEST_RUNNER = "androidx.test:runner:"
    const val TEST_RULES = "androidx.test:rules:"

    // Assertions
    const val JUNIT = "androidx.test.ext:junit:"
    const val GOOGLE_TRUTH = "com.google.truth:truth:"
    const val TRUTH = "androidx.test.ext:truth:"

    // UI Tests
    const val ESPRESSO_CORE = "androidx.test.espresso:espresso-core:"
    const val ESPRESSO_CONTRIB = "androidx.test.espresso:espresso-contrib:"
    const val ESPRESSO_IDLING_RESOURCE = "androidx.test.espresso:espresso-idling-resource:"

    // Firebase ------------------------------------------------------------------------------------
    const val PERFORMANCE = "com.google.firebase:firebase-perf:"
    const val ANALYTICS = "com.google.firebase:firebase-analytics-ktx:"
    const val CRASHLYTICS = "com.google.firebase:firebase-crashlytics:"

    // Network -------------------------------------------------------------------------------------
    const val RETROFIT = "com.squareup.retrofit2:retrofit:"
    const val RETROFIT_CONVERTER_GSON = "com.squareup.retrofit2:converter-gson:"
    const val GSON = "com.google.code.gson:gson:"
    const val OKHTTP = "com.squareup.okhttp3:logging-interceptor:"
    const val COIL = "io.coil-kt:coil:"

    // Utilities -----------------------------------------------------------------------------------
    const val LEAK_CANARY = "com.squareup.leakcanary:leakcanary-android:"
    const val TIMBER = "com.jakewharton.timber:timber:"
    const val INK_PAGE_INDICATOR = "com.pacioianu.david:ink-page-indicator:"

    // Tests ---------------------------------------------------------------------------------------
    const val JUNIT_JUPITER_API = "org.junit.jupiter:junit-jupiter-api:"
    const val JUNIT_JUPITER_PARAMS = "org.junit.jupiter:junit-jupiter-params:"
    const val JUNIT_JUPITER_ENGINE = "org.junit.jupiter:junit-jupiter-engine:"
    const val MOCKK_CORE = "io.mockk:mockk:"
    const val MOCKK_ANDROID = "io.mockk:mockk-android:"
    const val JUNIT4 = "junit:junit:"

}