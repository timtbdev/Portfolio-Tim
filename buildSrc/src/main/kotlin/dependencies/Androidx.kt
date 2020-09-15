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

object Androidx {

    // Libraries -----------------------------------------------------------------------------------

    // AndroidX
    private const val CORE_KTX = Libs.CORE_KTX + Versions.CORE_KTX
    private const val APP_COMPAT = Libs.APP_COMPAT + Versions.APP_COMPAT

    // Fragment
    private const val FRAGMENT_KTX = Libs.FRAGMENT_KTX + Versions.FRAGMENT

    // ViewModel
    private const val VM_KTX = Libs.VM_KTX + Versions.LIFECYCLE
    private const val VM_SAVED_STATE = Libs.VM_SAVED_STATE + Versions.LIFECYCLE

    // Live Data
    private const val LIVE_DATA_KTX = Libs.LIVE_DATA_KTX + Versions.LIFECYCLE

    // Navigation
    private const val NAV_FRAGMENT_KTX = Libs.NAV_FRAGMENT_KTX + Versions.NAVIGATION
    private const val NAV_UI_KTX = Libs.NAV_UI_KTX + Versions.NAVIGATION
    private const val NAV_DYNAMIC = Libs.NAV_DYNAMIC + Versions.NAVIGATION

    // Room
    private const val ROOM = Libs.ROOM + Versions.ROOM
    private const val ROOM_KTX = Libs.ROOM_KTX + Versions.ROOM

    // WorkManager
    private const val WORK_KTX = Libs.WORK_KTX + Versions.WORK

    // Paging
    private const val PAGING_KTX = Libs.PAGING_KTX + Versions.PAGING
    private const val PAGING_COMMON = Libs.PAGING_COMMON + Versions.PAGING

    // UI
    private const val MATERIAL_DESIGN = Libs.MATERIAL_DESIGN + Versions.MATERIAL_DESIGN
    private const val CONSTRAINT_LAYOUT = Libs.CONSTRAINT_LAYOUT + Versions.CONSTRAINT_LAYOUT

    // SwipeToRefreshLayout
    private const val SWIPE_REFRESH = Libs.SWIPE_REFRESH + Versions.SWIPE_REFRESH
    private const val VIEW_PAGER = Libs.VIEW_PAGER + Versions.VIEW_PAGER

    // RecyclerView
    private const val RV_CORE = Libs.RV_CORE + Versions.RV
    private const val RV_SELECTION = Libs.RV_SELECTION + Versions.RV_SELECTION

    // VectorDrawable
    private const val VD_CORE = Libs.VD_CORE + Versions.VD
    private const val VD_ANIMATED = Libs.VD_ANIMATED + Versions.VD_ANIMATED

    // Dynamic feature
    private const val GOOGLE_PLAY = Libs.GOOGLE_PLAY + Versions.GOOGLE_PLAY

    // Utils
    private const val PREFERENCE_KTX = Libs.PREFERENCE_KTX + Versions.PREFERENCE
    private const val APP_STARTUP = Libs.APP_STARTUP + Versions.APP_STARTUP
    private const val BROWSER = Libs.BROWSER + Versions.BROWSER

    object Modules {
        val app_dependencies: List<String>
            get() = listOf(
                CORE_KTX,
                APP_COMPAT,
                FRAGMENT_KTX,
                VM_KTX,
                VM_SAVED_STATE,
                LIVE_DATA_KTX,
                NAV_FRAGMENT_KTX,
                NAV_UI_KTX,
                NAV_DYNAMIC,
                CONSTRAINT_LAYOUT,
                MATERIAL_DESIGN,
                VD_CORE,
                VD_ANIMATED,
                GOOGLE_PLAY,
                APP_STARTUP
            )
    }
}