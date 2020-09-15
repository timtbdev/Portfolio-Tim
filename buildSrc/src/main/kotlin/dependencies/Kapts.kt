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

object Kapts {

    // Libraries -----------------------------------------------------------------------------------
    const val LIVE_DATA_KAPT = Libs.LIVE_DATA_KAPT + Versions.LIFECYCLE
    const val ROOM_KAPT = Libs.ROOM_KAPT + Versions.ROOM
    const val HILT_KAPT = Libs.HILT_KAPT + Versions.HILT

    // Dependencies --------------------------------------------------------------------------------

    object Modules {
        val app_dependencies: List<String>
            get() = listOf(
                LIVE_DATA_KAPT,
                HILT_KAPT
            )
    }
}