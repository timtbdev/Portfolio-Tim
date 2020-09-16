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

package dependencies

import constants.Libs
import constants.Versions
import interfaces.*


object Androidx {

    // Base
    const val KTX = Libs.CORE_KTX + Versions.CORE_KTX

    // Others
    const val SWIPE_REFRESH = Libs.SWIPE_REFRESH + Versions.SWIPE_REFRESH
    const val VIEW_PAGER = Libs.VIEW_PAGER + Versions.VIEW_PAGER
    const val PREFERENCE = Libs.PREFERENCE + Versions.PREFERENCE
    const val APP_STARTUP = Libs.APP_STARTUP + Versions.APP_STARTUP
    const val BROWSER = Libs.BROWSER + Versions.BROWSER

    object Layout : Deps {
        // Libraries -------------------------------------------------------------------------------
        private const val APP_COMPAT = Libs.APP_COMPAT + Versions.APP_COMPAT
        private const val CONSTRAINT_LAYOUT = Libs.CONSTRAINT_LAYOUT + Versions.CONSTRAINT_LAYOUT
        private const val MATERIAL_DESIGN = Libs.MATERIAL_DESIGN + Versions.MATERIAL_DESIGN
        private const val VD_CORE = Libs.VD_CORE + Versions.VD
        private const val VD_ANIMATED = Libs.VD_ANIMATED + Versions.VD_ANIMATED

        // Dependencies ----------------------------------------------------------------------------
        override val dependencies: List<String>
            get() = listOf(
                APP_COMPAT,
                CONSTRAINT_LAYOUT,
                MATERIAL_DESIGN,
                VD_CORE,
                VD_ANIMATED
            )
    }

    object Compose : DepsTest {
        // Libraries -------------------------------------------------------------------------------
        private const val UI = Libs.COMPOSE_UI + Versions.COMPOSE
        private const val UI_TOOLING = Libs.COMPOSE_UI_TOOLING + Versions.COMPOSE
        private const val FOUNDATION = Libs.COMPOSE_FOUNDATION + Versions.COMPOSE
        private const val MATERIAL_DESIGN = Libs.COMPOSE_MATERIAL_DESIGN + Versions.COMPOSE
        private const val LIVE_DATA = Libs.COMPOSE_LIVE_DATA + Versions.COMPOSE
        private const val UI_TEST = Libs.COMPOSE_UI_TEST + Versions.COMPOSE

        // Dependencies ----------------------------------------------------------------------------
        override val dependencies: List<String>
            get() = listOf(
                UI,
                UI_TOOLING,
                FOUNDATION,
                MATERIAL_DESIGN,
                LIVE_DATA
            )

        // Tests -----------------------------------------------------------------------------------
        override val test = UI_TEST
    }

    object ViewModel : Deps {
        // Libraries -------------------------------------------------------------------------------
        private const val CORE_KTX = Libs.VIEW_MODEL + Versions.LIFECYCLE
        private const val SAVED_STATE = Libs.VIEW_MODEL_SAVED_STATE + Versions.LIFECYCLE

        // Dependencies ----------------------------------------------------------------------------
        override val dependencies: List<String>
            get() = listOf(
                CORE_KTX,
                SAVED_STATE
            )
    }

    object LiveData : DepTestKapt {
        // Libraries -------------------------------------------------------------------------------
        private const val CORE = Libs.LIVE_DATA + Versions.LIFECYCLE
        private const val KAPT = Libs.LIVE_DATA_KAPT + Versions.LIFECYCLE
        private const val TEST = Libs.ARCH_TEST + Versions.ARCH_TEST

        // Dependencies ----------------------------------------------------------------------------
        override val dependency = CORE

        // Tests -----------------------------------------------------------------------------------
        override val test = TEST

        // Kapts -----------------------------------------------------------------------------------
        override val kapt = KAPT
    }

    object Fragment : DepDebug {
        // Libraries -------------------------------------------------------------------------------
        private const val CORE = Libs.FRAGMENT + Versions.FRAGMENT
        private const val TEST = Libs.FRAGMENT_TEST + Versions.FRAGMENT

        // Dependencies ----------------------------------------------------------------------------
        override val dependency = CORE

        // Tests -----------------------------------------------------------------------------------
        override val debug = TEST
    }

    object Navigation : DepsAndroidTest {
        // Libraries -------------------------------------------------------------------------------
        private const val FRAGMENT = Libs.NAV_FRAGMENT + Versions.NAVIGATION
        private const val UI_KTX = Libs.NAV_UI_KTX + Versions.NAVIGATION
        private const val TEST = Libs.NAV_TEST + Versions.NAVIGATION

        // Dependencies ----------------------------------------------------------------------------
        override val dependencies: List<String>
            get() = listOf(
                FRAGMENT,
                UI_KTX
            )

        // Tests -----------------------------------------------------------------------------------
        override val androidTest = TEST
    }

    object Room : DepsTestKapt {
        // Libraries -------------------------------------------------------------------------------
        private const val RUNTIME = Libs.ROOM_RUNTIME + Versions.ROOM
        private const val KTX = Libs.ROOM_KTX + Versions.ROOM
        private const val TEST = Libs.ROOM_TEST + Versions.ROOM
        private const val KAPT = Libs.ROOM_KAPT + Versions.ROOM

        // Dependencies ----------------------------------------------------------------------------
        override val dependencies: List<String>
            get() = listOf(RUNTIME, KTX)

        // Tests -----------------------------------------------------------------------------------
        override val test = TEST

        // Kapts -----------------------------------------------------------------------------------
        override val kapt = KAPT

    }

    object WorkManager : DepAndroidTest {
        // Libraries -------------------------------------------------------------------------------
        private const val RUNTIME = Libs.WORK_RUNTIME + Versions.WORK
        private const val TEST = Libs.WORK_TEST + Versions.WORK

        // Dependencies ----------------------------------------------------------------------------
        override val dependency = RUNTIME

        // Tests -----------------------------------------------------------------------------------
        override val androidTest = TEST
    }

    object Paging : Deps {
        // Libraries -------------------------------------------------------------------------------
        private const val RUNTIME = Libs.PAGING_RUNTIME + Versions.PAGING
        private const val COMMON = Libs.PAGING_COMMON + Versions.PAGING

        // Dependencies ----------------------------------------------------------------------------
        override val dependencies: List<String>
            get() = listOf(RUNTIME, COMMON)
    }

    object DynamicFeature : Deps {
        // Libraries -------------------------------------------------------------------------------
        private const val NAV = Libs.NAV_DYNAMIC + Versions.NAVIGATION
        private const val GOOGLE_PLAY = Libs.GOOGLE_PLAY + Versions.GOOGLE_PLAY

        // Dependencies ----------------------------------------------------------------------------
        override val dependencies: List<String>
            get() = listOf(NAV, GOOGLE_PLAY)
    }

    object RecyclerView : Deps {
        // Libraries -------------------------------------------------------------------------------
        const val CORE = Libs.RV_CORE + Versions.RV
        const val SELECTION = Libs.RV_SELECTION + Versions.RV_SELECTION

        // Dependencies ----------------------------------------------------------------------------
        override val dependencies: List<String>
            get() = listOf(CORE, SELECTION)
    }

    object DaggerHilt : DepsKapt {
        // Libraries -------------------------------------------------------------------------------
        private const val ANDROID = Libs.HILT_ANDROID + Versions.HILT
        private const val KAPT = Libs.HILT_KAPT + Versions.HILT

        // Dependencies ----------------------------------------------------------------------------
        override val dependencies: List<String>
            get() = listOf(ANDROID)

        // Dependencies ----------------------------------------------------------------------------
        override val kapt = KAPT
    }

    object DataStore : Deps {
        // Libraries -------------------------------------------------------------------------------
        private const val CORE = Libs.DATA_STORE_CORE + Versions.DATA_STORE
        private const val PREFERENCE = Libs.DATA_STORE_PREFERENCE + Versions.DATA_STORE

        // Dependencies ----------------------------------------------------------------------------
        override val dependencies: List<String>
            get() = listOf(CORE, PREFERENCE)
    }
}