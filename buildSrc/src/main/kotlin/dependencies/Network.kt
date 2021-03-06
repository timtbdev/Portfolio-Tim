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
import interfaces.Deps

object Network : Deps {

    // Libraries -----------------------------------------------------------------------------------
    private const val RETROFIT = Libs.RETROFIT + Versions.RETROFIT
    private const val RETROFIT_CONVERTER_GSON = Libs.RETROFIT_CONVERTER_GSON + Versions.RETROFIT
    private const val GSON = Libs.GSON + Versions.GSON
    private const val OKHTTP = Libs.OKHTTP + Versions.OKHTTP
    private const val COIL = Libs.COIL + Versions.COIL

    // Dependencies --------------------------------------------------------------------------------
    override val dependencies: List<String>
        get() = listOf(
            RETROFIT,
            RETROFIT_CONVERTER_GSON,
            GSON,
            OKHTTP,
            COIL
        )
}