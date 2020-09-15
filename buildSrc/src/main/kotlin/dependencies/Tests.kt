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

object Tests : Deps {

    // Libraries -----------------------------------------------------------------------------------
    private const val JUPITER_API = Libs.JUNIT_JUPITER_API + Versions.JUNIT_JUPITER
    private const val JUPITER_PARAMS = Libs.JUNIT_JUPITER_PARAMS + Versions.JUNIT_JUPITER
    private const val JUPITER_ENGINE = Libs.JUNIT_JUPITER_ENGINE + Versions.JUNIT_JUPITER
    private const val MOCKK_CORE = Libs.MOCKK_CORE + Versions.MOCKK
    private const val MOCKK_ANDROID = Libs.MOCKK_ANDROID + Versions.MOCKK
    private const val JUNIT4 = Libs.JUNIT4 + Versions.JUNIT4

    // Dependencies --------------------------------------------------------------------------------
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